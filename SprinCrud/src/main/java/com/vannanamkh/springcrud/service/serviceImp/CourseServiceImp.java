package com.vannanamkh.springcrud.service.serviceImp;

import com.vannanamkh.springcrud.model.Courses;
import com.vannanamkh.springcrud.model.request.CoursesRequest;
import com.vannanamkh.springcrud.repository.CourseRepository;
import com.vannanamkh.springcrud.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseReposotory ;

    @Override
    public List<Courses> getALlCourse( int page,int size ) {
        return courseReposotory.getCourses(page , size);
    }

    @Override
    public Courses getCourseById(Long id) {
        return courseReposotory.getCourseById(id);
    }


    @Override
    public Courses postCourse(CoursesRequest coursesRequest){
        return courseReposotory.saveCourse(coursesRequest);
    }


    @Override
    public Courses updateCourse(Long id, CoursesRequest coursesRequest) {
        return courseReposotory.updateCourse(id,coursesRequest);
    }

    @Override
    public Courses deleteCourse(Long id) {
        return courseReposotory.deleteCourse(id);
    }


}
