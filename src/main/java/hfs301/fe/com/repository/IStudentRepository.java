package hfs301.fe.com.repository;
import hfs301.fe.com.pojo.Student;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    void delete(int studentID);
    Student findById(int studentID);
    void update(Student student);
}