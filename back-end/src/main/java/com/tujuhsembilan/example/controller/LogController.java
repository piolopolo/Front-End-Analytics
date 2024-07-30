// src/main/java/com/tujuhsembilan/example/controller/LogController.java

package com.tujuhsembilan.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tujuhsembilan.example.dto.LogRequest;
import com.tujuhsembilan.example.service.LogService;

@RestController
@RequestMapping("/sample")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/log")
    public ResponseEntity<?> receiveLog(@RequestBody LogRequest logRequest) {
        logService.saveLog(logRequest);
        return ResponseEntity.ok().build();
    }
}
