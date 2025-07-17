package org.example.jpacrudtest.controller;

import org.example.jpacrudtest.model.Student;
import org.example.jpacrudtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    //entire students returns
    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.getStd();
    }
    //students returns based on the id
    @GetMapping("/student/{id}")
    public Student getStudentId(@PathVariable int id) {
        return studentService.getStdId(id);
    }
    //students returns based on the department name by declaring user defined method
    @GetMapping("/student/department/{deptName}")
    public List<Student> getStudentDept(@PathVariable("deptName") String dept)
    {
        return studentService.getStdDpt(dept);
    }
    //students returns based on the name by declaring user defined method
    @GetMapping("/student/name/{name}")
    public Student getStudentName(@PathVariable("name") String name) {
        return studentService.getStdName(name);
    }
    //creating a new student
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        studentService.addStd(student);
        return "student added successfully";

    }
    //filtering the student by using native query jpql
    @PostMapping("/student/filter")
    public List<Student> filterStudentsByGenderAndDept(@Param("gender") String gender,@Param("dept") String dept)
    {
        return studentService.filterStdByGenAndDept(gender,dept);
    }
    //updating the existing student
    @PutMapping("/student")
    public String updateStudent(@RequestBody Student student)
    {
        studentService.updateStd(student);
        return "student updated successfully";

    }
    //deleting the student
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


