package com.tranana.cruddemo.dao;

import com.tranana.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
