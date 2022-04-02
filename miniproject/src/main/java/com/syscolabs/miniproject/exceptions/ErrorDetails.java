package com.syscolabs.miniproject.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ErrorDetails {
    private Date timestamp;
    private HttpStatus status;
    private String message;
    private String details;
}
