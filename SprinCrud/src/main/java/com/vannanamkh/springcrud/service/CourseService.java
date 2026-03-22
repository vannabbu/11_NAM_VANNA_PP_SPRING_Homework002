package com.vannanamkh.springcrud.service;

import com.vannanamkh.springcrud.model.Courses;
import com.vannanamkh.springcrud.model.request.CoursesRequest;

import java.util.List;
public interface CourseService {
    List<Courses> getALlCourse(int page,int size);
    Courses getCourseById(Long id);
    Courses postCourse(CoursesRequest coursesRequest);
    Courses updateCourse( Long id ,CoursesRequest coursesRequest);
    Courses deleteCourse(Long id);

}
