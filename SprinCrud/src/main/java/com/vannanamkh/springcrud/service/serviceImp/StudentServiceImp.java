package com.vannanamkh.springcrud.service.serviceImp;

import com.vannanamkh.springcrud.model.Students;
import com.vannanamkh.springcrud.model.request.StudentRequest;
import com.vannanamkh.springcrud.repository.StudentCourseRepository;
import com.vannanamkh.springcrud.repository.StudentRepository;
import com.vannanamkh.springcrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository ;
    private final StudentCourseRepository studentCourseRepository;
    @Override
    public List<Students> getAllStudent(int page , int size) {
        return studentRepository.getAllStudent(page , size);
    }

    @Override
    public Students getStudentById(Long id) {
        return studentRepository.getStudentBuyId(id);
    }

    @Override
    public Students postStudent(StudentRequest studentRequest) {

        Students students = studentRepository.postStudent(studentRequest);

        for(Long courseId : studentRequest.getCourseId()){
            studentCourseRepository.saveStudentCourse(students.getId() ,courseId);
        }
        return studentRepository.getStudentBuyId(students.getId());
    }

    @Override
    public Students updateStudent(Long id, StudentRequest studentRequest) {

      studentRepository.updateStudent(id, studentRequest);

        studentCourseRepository.deleteByStudentId(id);
        for(Long courseId : studentRequest.getCourseId()){
            studentCourseRepository.saveStudentCourse(id, courseId);
        }

        Students students = studentRepository.getStudentBuyId(id);
        return students;
    }


    @Override
    public Students deleteStudent(Long id) {
        return studentRepository.deleteStudent(id);
    }
}
