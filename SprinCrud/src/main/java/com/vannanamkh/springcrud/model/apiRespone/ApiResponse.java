package com.vannanamkh.springcrud.model.apiRespone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T>  {

    private boolean success;
    public String message ;
    private HttpStatus status;
    public T payload ;
    public Instant timeStamp;
}
