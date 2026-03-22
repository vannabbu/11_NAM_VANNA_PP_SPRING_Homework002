package com.vannanamkh.springcrud.service;


import com.vannanamkh.springcrud.model.Students;
import com.vannanamkh.springcrud.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Students> getAllStudent(int page , int size );
    Students getStudentById(Long id) ;
    Students postStudent(StudentRequest studentRequest);
    Students updateStudent (Long id, StudentRequest studentRequest) ;
    Students deleteStudent (Long id ) ;
}
