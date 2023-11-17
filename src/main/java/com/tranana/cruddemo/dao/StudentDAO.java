package com.tranana.cruddemo.dao;

import com.tranana.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> finalAll();
}
