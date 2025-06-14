package hfs301.fe.com.service;

import hfs301.fe.com.dao.IStudentDAO;
import hfs301.fe.com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IStudentDAO studentDAO;

    public void save(Student student) { studentDAO.save(student); }
    public List<Student> getAll() { return studentDAO.getAll(); }
    public void delete(int id) { studentDAO.delete(id); }
    public Student findById(int id) { return studentDAO.findById(id); }
    public void update(Student student) { studentDAO.update(student); }
}
