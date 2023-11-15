package com.tranana.cruddemo.dao;

import com.tranana.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //gives support for component scanning and handles spring support for exceptions translations
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save,method
    @Override
    @Transactional   // used since we are performing an update on the database from spring framework
    public void save(Student theStudent) {
        entityManager.persist(theStudent); //saves student to the database
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }
}
