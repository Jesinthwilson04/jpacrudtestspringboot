package org.example.jpacrudtest.repository;

import org.example.jpacrudtest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
     List<Student> findByDept(String dept);
    Student findByName(String name);
    @Query(value="select * from student where gender=:gender and dept=:dept",
    nativeQuery=true)
    List<Student> filterByStudGenderAndDept(
            @Param("gender") String gender, @Param("dept") String dept);
}
