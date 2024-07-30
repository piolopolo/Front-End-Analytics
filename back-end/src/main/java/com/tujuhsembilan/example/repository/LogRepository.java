package com.tujuhsembilan.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujuhsembilan.example.model.LogData;

public interface LogRepository extends JpaRepository<LogData, Long> {
}
