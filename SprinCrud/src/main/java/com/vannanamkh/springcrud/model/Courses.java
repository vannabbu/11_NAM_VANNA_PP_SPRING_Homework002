package com.vannanamkh.springcrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private int id ;
    private String courseName ;
    private String description;
    private int instructorId ;
    private Instructor instructor;
}
