package org.example.jpacrudtest.controller;

import org.example.jpacrudtest.model.Student;
import org.example.jpacrudtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getStudentId(@PathVariable int id) {
        Student std= studentService.getStdId(id);
        if (std == null) {
            return new ResponseEntity<>("There is no student in that rollno",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(std,HttpStatus.OK);
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
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStd(student);
        return new ResponseEntity<>("Student added",HttpStatus.OK);
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


