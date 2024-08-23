package com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseException {
    private final String message;
    private final String code;
    private final LocalDateTime timestamp;

    public ResponseException(String message, String code, LocalDateTime timestamp) {
        this.message = message;
        this.code = code;
        this.timestamp = timestamp;
    }

}