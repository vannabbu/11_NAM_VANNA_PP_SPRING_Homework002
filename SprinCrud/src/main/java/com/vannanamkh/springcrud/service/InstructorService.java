package com.vannanamkh.springcrud.service;

import com.vannanamkh.springcrud.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getALlInstructor(int page , int size);
    Instructor getInstructorById(Long id);
    Instructor postInstructor(Instructor instructor);
    List<Instructor> updateInstructor( Long id ,Instructor instructor);
    Instructor deleteInstructor(Long id);

}
