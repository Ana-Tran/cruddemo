package com.tranana.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student") // database name in SQL
public class Student {

    // define fields and map fields to appropriate database columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tells java SQL will handle id generation
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    // define constructors
    public Student(){

    }

    // right click and select generate to auto generate constructor with arguments
    public Student(String firstName, String last_name, String email) {
        this.firstName = firstName;
        this.lastName = last_name;
        this.email = email;
    }
    // define getters/setters, auto generate

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define toString() method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
