package com.vannanamkh.springcrud.controller;

import com.vannanamkh.springcrud.model.Instructor;
import com.vannanamkh.springcrud.model.apiRespone.ApiResponse;
import com.vannanamkh.springcrud.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    @GetMapping
    @Operation(summary = "get all Instructor")
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructor(@Param("page") int page  , @Param("size") int size){
        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Get Successfully")
                .payload(instructorService.getALlInstructor(page , size))
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


    @GetMapping("/{id}")
    @Operation(summary = "get instructor by id")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable Long id){
        if(instructorService.getInstructorById(id)!=null){
            ApiResponse apiResponse = ApiResponse.builder()
                    .success(true)
                    .message("Get by id : "+id+" Successfully")
                    .status(HttpStatus.OK)
                    .payload(instructorService.getInstructorById(id))
                    .timeStamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }

        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
                .timeStamp(Instant.now())
                .message("Not Fount")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PostMapping
    @Operation(summary = "create a new instructor")
    public ResponseEntity<ApiResponse<Instructor>> saveInstructor(@RequestBody Instructor instructor){

        ApiResponse apiResponse = ApiResponse.builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Save successful")
                .payload(instructor)
                .timeStamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping("/{instructor-id}")
    @Operation(summary = "update instructor by id")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable("instructor-id") long id , @RequestBody Instructor instructor){
        if(instructor.getId().equals(instructorService.getInstructorById(id))){
            ApiResponse apiResponse = ApiResponse.builder()
                    .timeStamp(Instant.now())
                    .message("update successful")
                    .payload(instructorService.updateInstructor( id ,instructor ))
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(Instant.now())
                .message("ID not Found")
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{instructor-id}")
    @Operation(summary = "delete instructor by id")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable("instructor-id") Long id) {
        if (id.equals(instructorService.getInstructorById(id))) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .timeStamp(Instant.now())
                    .message("delete successful")
                    .payload(instructorService.getInstructorById(id))
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }

        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(Instant.now())
                .message("not found ")
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }
}
