package hfs301.fe.com.service;
import hfs301.fe.com.pojo.Student;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    void delete(int studentID);
    Student findById(int studentID);
    void update(Student student);
}