package com.example.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="userdetails")
public class userdtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String userType;
    private String department;
    private String role;
}


//  What/Why  we use in the code
//      @Entity----  @Entity tells Spring Boot that the class represents a table in the database. It makes it easy to save, update, and fetch data from the database.
//      @Id---- in Spring Boot marks a field as the primary key of the database table. It uniquely identifies each record in the table.
//      @GeneratedValue---- is used to automatically generate the value for the primary key (@Id). It defines how the ID is generated.

//      toString()---->The toString() method is used to generate a string representation of an object.
//          It's often overridden in custom classes to provide a more meaningful output when the object is printed or logged.
//          Without the toString() method, the default toString() would print the class name and its hashcode (something like Userdetails@15db9742), which is less helpful.
//          with the toString(), userdtls{id=1, name='John Doe', password='password123', email='john@example.com', userType='admin', department='IT'}