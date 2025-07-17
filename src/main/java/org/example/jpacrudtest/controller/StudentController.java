package org.example.jpacrudtest.controller;

import org.example.jpacrudtest.model.Student;
import org.example.jpacrudtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.getStd();
    }
    @GetMapping("/student/{id}")
    public Student getStudentId(@PathVariable int id) {
        return studentService.getStdId(id);
    }
    @GetMapping("/student/dept/{deptName}")
    public List<Student> getStudentDept(@PathVariable("deptName") String dept)
    {
        return studentService.getStdDpt(dept);
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        studentService.addStd(student);
        return "student added successfully";
    }
    @PutMapping("/student")
    public String updateStudent(@RequestBody Student student)
    {
        studentService.updateStd(student);
        return "student updated successfully";

    }
    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable int id) {
        try {
            studentService.delstd(id);
            return "student deleted successfully";
        }
        catch (Exception e) {
            return "student not found";
        }
    }
    }


