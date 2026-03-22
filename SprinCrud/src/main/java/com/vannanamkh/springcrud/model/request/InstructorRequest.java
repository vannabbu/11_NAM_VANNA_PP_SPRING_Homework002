package com.vannanamkh.springcrud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private Long id ;
    private String instructorName;
    private String email ;
}
