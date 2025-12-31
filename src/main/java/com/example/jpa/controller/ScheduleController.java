package com.example.jpa.controller;

import com.example.jpa.dto.ScheduleUpdateResponse;
import com.example.jpa.dto.ScheduleCreateRequest;
import com.example.jpa.dto.ScheduleCreateResponse;
import com.example.jpa.dto.ScheduleGetResponse;
import com.example.jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponse> create (
            @RequestBody ScheduleCreateRequest request
    ) {
        ScheduleCreateResponse schedule = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(schedule);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());

    }

    @GetMapping("/schedules/{schedulesId}")
    public ResponseEntity<ScheduleGetResponse> getOne(@PathVariable Long schedulesId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(schedulesId));
    }

    @PutMapping("/schedules/{schedulesId}")
    public ResponseEntity<ScheduleUpdateResponse> update (
            @PathVariable Long schedulesId,
            @RequestBody ScheduleCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(schedulesId, request));
    }

    @DeleteMapping("/schedules/{schedulesId}")
    public void delete(@PathVariable Long schedulesId) {

        scheduleService.delete(schedulesId);
    }

}
