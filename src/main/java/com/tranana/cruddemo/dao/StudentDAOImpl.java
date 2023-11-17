package com.tranana.cruddemo.dao;

import com.tranana.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> finalAll() {
        // create query ** all JPQL syntax based on entity name and fields not database
        TypedQuery<Student> getStudents = entityManager.createQuery("FROM Student",Student.class);

        // return query result
        return getStudents.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query with named parameters that will be filled later
        TypedQuery<Student> findLastName = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);
        //set query parameters
        findLastName.setParameter("theData", theLastName);
        // return query results
        return findLastName.getResultList();
    }
}
