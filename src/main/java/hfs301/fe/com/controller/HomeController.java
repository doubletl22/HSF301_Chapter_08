package hfs301.fe.com.controller;

import hfs301.fe.com.pojo.Student;
import hfs301.fe.com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "home";
    }

    @PostMapping("/student")
    public String handleStudent(
            @RequestParam String action,
            @ModelAttribute Student student,
            Model model) {
        switch (action) {
            case "add":
                studentService.save(student);
                break;
            case "update":
                studentService.update(student);
                break;
            case "delete":
                studentService.delete(student.getId());
                break;
        }
        // Quay lại trang home sau khi thao tác xong
        return "redirect:/home";
    }
}
