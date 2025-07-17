package org.example.jpacrudtest.service;

import org.example.jpacrudtest.model.Student;
import org.example.jpacrudtest.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public List<Student> getStd() {
        return studentRepo.findAll();

    }

    public void addStd(Student student) {
        studentRepo.save(student);
    }

    public Student getStdId(int id) {
        return studentRepo.findById(id).orElse(new Student());
        }

    public void updateStd(Student student) {
        studentRepo.save(student);

    }

    public void delstd(int id) {
        if(studentRepo.findById(id).isPresent()) {
            studentRepo.deleteById(id);
        }
        else{
            throw new RuntimeException("student not found");
        }

    }
}

