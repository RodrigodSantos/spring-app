package com.example.demo.gomes.spring_app.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionModel {
    private String message;
    private String description;
    private LocalDateTime date;
}
