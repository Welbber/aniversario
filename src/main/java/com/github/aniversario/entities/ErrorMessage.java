package com.github.aniversario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {
    private Integer statusCode;
    private String message;
}
