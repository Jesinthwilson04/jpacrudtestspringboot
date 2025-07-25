package org.example.jpacrudtest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
//student table
public class Student {
    @Id
    private int id;
    private String name;
    private String gender;
    private String fatherName;
    private String dept;
}
