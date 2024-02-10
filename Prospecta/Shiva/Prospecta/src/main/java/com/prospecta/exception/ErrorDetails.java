package com.prospecta.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private String message;
    private String description;
    private LocalDateTime localDateTime;
}
