// src/main/java/com/tujuhsembilan/example/service/LogService.java

package com.tujuhsembilan.example.service;

import org.springframework.stereotype.Service;
import com.tujuhsembilan.example.dto.LogRequest;
import com.tujuhsembilan.example.model.LogData;
import com.tujuhsembilan.example.repository.LogRepository;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveLog(LogRequest logRequest) {
        LogData logData = new LogData();
        logData.setMessage(logRequest.getMessage());
        logData.setSource(logRequest.getSource());
        logData.setLineno(logRequest.getLineno());
        logData.setColno(logRequest.getColno());
        logData.setError(logRequest.getError());
        logData.setUserAgent(logRequest.getUserAgent());
        logData.setUrl(logRequest.getUrl());
        logData.setTimestamp(logRequest.getTimestamp());
        logRepository.save(logData);
    }
}
