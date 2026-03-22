package com.vannanamkh.springcrud.service.serviceImp;

import com.vannanamkh.springcrud.model.Instructor;
import com.vannanamkh.springcrud.repository.InstructorRepository;
import com.vannanamkh.springcrud.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServiceImp implements InstructorService {

    private  final InstructorRepository instructorRepository;

    InstructorServiceImp(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getALlInstructor(int page , int size){

        return instructorRepository.getALlInstructors( page , size);
    }
    public Instructor getInstructorById(Long id){
        return instructorRepository.getInstructorById(id);
    }
    public Instructor postInstructor(Instructor instructor){
        return instructorRepository.postInstructor(instructor);
    }
    public  List<Instructor> updateInstructor( Long id  ,Instructor instructor){
        return instructorRepository.updateInstructor(id , instructor);
    }

    public Instructor deleteInstructor(Long id) {
        return instructorRepository.deleteInstructor(id);
    }
}
