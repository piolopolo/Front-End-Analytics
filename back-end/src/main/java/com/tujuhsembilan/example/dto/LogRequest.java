// src/main/java/com/tujuhsembilan/example/dto/LogRequest.java

package com.tujuhsembilan.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogRequest {
    private String message;
    private String source;
    private int lineno;
    private int colno;
    private String error;
    private String userAgent;
    private String url;
    private String timestamp;
}
