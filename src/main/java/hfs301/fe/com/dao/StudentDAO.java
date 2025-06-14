package hfs301.fe.com.dao;

import hfs301.fe.com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        // Tạo bảng nếu chưa có
        String sql = "CREATE TABLE IF NOT EXISTS student (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void save(Student student) {
        jdbcTemplate.update("INSERT INTO student(name, email) VALUES (?, ?)",
                student.getName(), student.getEmail());
    }

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                return s;
            }
        });
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }

    @Override
    public Student findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM student WHERE id = ?",
                (rs, rowNum) -> {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setEmail(rs.getString("email"));
                    return s;
                },
                id // tham số truyền trực tiếp ở cuối
        );

    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update(
                "UPDATE student SET name=?, email=? WHERE id=?",
                student.getName(), student.getEmail(), student.getId()
        );
    }
}
