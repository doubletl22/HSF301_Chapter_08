package hfs301.fe.com.dao;


import hfs301.fe.com.pojo.Student;
import java.util.List;

public interface IStudentDAO {
    void save(Student student);
    List<Student> getAll();
    void delete(int id);
    Student findById(int id);
    void update(Student student);
}
