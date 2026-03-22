package com.vannanamkh.springcrud.controller;


import com.vannanamkh.springcrud.model.Courses;
import com.vannanamkh.springcrud.model.apiRespone.ApiResponse;
import com.vannanamkh.springcrud.model.request.CoursesRequest;
import com.vannanamkh.springcrud.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService ;
    @GetMapping
    @Operation(summary = "get all course")
    public ResponseEntity<ApiResponse<List<Courses>>> getALlCourse(@Param("page") int page,
                                                                   @Param("size") int size){

        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Get Course Successfully")
                .payload(courseService.getALlCourse(page , size))
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{course-id}")
    @Operation(summary = "get all course by id")
    public ResponseEntity<ApiResponse<Courses>> getCourseById(@PathVariable("course-id") Long id) {

        if(courseService.getCourseById(id) !=null) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get By Id Successfully")
                    .payload(courseService.getCourseById(id))
                    .timeStamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }

        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .message(" Id NOT Found ")
                .payload(null)
                .timeStamp(Instant.now())
                .build();


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "create a new course")
    public ResponseEntity<ApiResponse<Courses>> saveCourse(@RequestBody CoursesRequest coursesRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Create succesfully")
                .payload(courseService.postCourse(coursesRequest))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/course-{id}")
    @Operation(summary = "update course by id ")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(@PathVariable("course-id") Long id , @RequestBody CoursesRequest coursesRequest){
        if(courseService.getCourseById(id) != null) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .message("Update successfully")
                    .status(HttpStatus.OK)
                    .payload(updateCourse(id , coursesRequest))
                    .timeStamp(Instant.now())
                    .build() ;
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        }

        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .message("ID Not Found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .build() ;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @DeleteMapping("/{course-id}")
    @Operation(summary = "delete course by id")
    public ResponseEntity<ApiResponse<Courses>> deleteCourse(@PathVariable("course-id") Long id){
        if(courseService.getCourseById(id) != null) {

            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .message("delete id ="+ id +"successfully")
                    .payload(courseService.deleteCourse(id))
                    .status(HttpStatus.OK)
                    .build() ;
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }

        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .message("ID Not Found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timeStamp(Instant.now())
                .build() ;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }


}
