package com.example.connecting_to_db.entity;
import jakarta.persistence.*;
@Entity
@Table(name="User_details")
public class Userdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private String email;
    private String userType;
    private String department;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    @Override
    public String toString() {
        return "Userdetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", department='" + department + '\'' + '}';}}
//  What/Why  we use in the code
//      @Entity----  @Entity tells Spring Boot that the class represents a table in the database. It makes it easy to save, update, and fetch data from the database.
//      @Id---- in Spring Boot marks a field as the primary key of the database table. It uniquely identifies each record in the table.
//      @GeneratedValue---- is used to automatically generate the value for the primary key (@Id). It defines how the ID is generated.

//      toString()---->The toString() method is used to generate a string representation of an object.
//          It's often overridden in custom classes to provide a more meaningful output when the object is printed or logged.
//          Without the toString() method, the default toString() would print the class name and its hashcode (something like Userdetails@15db9742), which is less helpful.
//          with the toString(), Userdetails{id=1, name='John Doe', password='password123', email='john@example.com', userType='admin', department='IT'}