package com.vannanamkh.springcrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    private Long id ;
    private String instructorName  ;
    private String email ;
}
