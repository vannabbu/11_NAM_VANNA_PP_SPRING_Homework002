package com.vannanamkh.springcrud.controller;

import com.vannanamkh.springcrud.model.Students;
import com.vannanamkh.springcrud.model.apiRespone.ApiResponse;
import com.vannanamkh.springcrud.model.request.StudentRequest;
import com.vannanamkh.springcrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private  final StudentService studentService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Students>>> getAllStudent(@Param("page") int page , @Param("size") int size){
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .message("Get all Student successfully")
                .status(HttpStatus.OK)
                .payload(studentService.getAllStudent(page ,size))
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse) ;
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> getStudentById(@PathVariable("student-id") Long id){
        if(studentService.getStudentById(id) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .message("Get Id "+ id +"successfully")
                    .status(HttpStatus.OK)
                    .payload(studentService.getStudentById(id))
                    .timeStamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse) ;
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .message("Id Not Found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse) ;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Students>> postStudent(@RequestBody StudentRequest studentRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .message("Save successfully")
                .status(HttpStatus.CREATED)
                .payload(studentService.postStudent(studentRequest))
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse) ;
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> updateStudent(@PathVariable("student-id") long id , @RequestBody StudentRequest studentRequest){
        if(studentService.getStudentById(id) !=null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .timeStamp(Instant.now())
                    .message("update successful")
                    .payload(studentService.updateStudent( id ,studentRequest ))
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(Instant.now())
                .message("ID not Found")
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> deleteStudents(@PathVariable("student-id") Long id) {
        if (studentService.getStudentById(id) != null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("delete successful")
                    .payload(studentService.deleteStudent(id))
                    .timeStamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .message("Id not found ")
                .payload(null)
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
