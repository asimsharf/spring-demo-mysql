package com.example.demo.dao;
import com.example.demo.entity.Student;

import java.util.List;
// StudentDataAccessObject
// StudentDataAccessObjectImplementation

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName (String theLastName);

    void update(Student theStudent);

    void delete(Integer theID);

    int deleteAll();
}
