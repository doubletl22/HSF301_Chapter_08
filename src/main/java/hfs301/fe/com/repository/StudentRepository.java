package hfs301.fe.com.repository;

import hfs301.fe.com.dao.StudentDAO;
import hfs301.fe.com.pojo.Student;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private StudentDAO studentDAO = null;

    public StudentRepository(String fileConfig) {
        // Giả sử bạn đã sửa tên tệp DAO
        studentDAO = new StudentDAO();
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.getAll();
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    // --- BỔ SUNG CÁC PHƯƠNG THỨC CÒN THIẾU ---
    @Override
    public void delete(int studentID) {
        studentDAO.delete(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return studentDAO.findById(studentID);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }
}