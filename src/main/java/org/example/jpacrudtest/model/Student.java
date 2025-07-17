package org.example.jpacrudtest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String fatherName;
    private String dept;
}
