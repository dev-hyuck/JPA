package com.example.jpa.service;

import com.example.jpa.dto.*;
import com.example.jpa.entity.Schedule;
import com.example.jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleCreateResponse save(ScheduleCreateRequest request) {
        Schedule schedule = new Schedule (
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword());

        Schedule savedschedule = scheduleRepository.save(schedule);
        return new ScheduleCreateResponse(
                savedschedule.getId(),
                savedschedule.getTitle(),
                savedschedule.getContent(),
                savedschedule.getAuthor(),
                savedschedule.getPassword(),
                savedschedule.getCreatedAt(),
                savedschedule.getModifiedAt()
        );
    }

    @Transactional (readOnly = true)
    public  List<ScheduleGetResponse> findAll(String author) {
//      scheduleRepository.findAll(); // 불필요한 중복 호출 사용 주석 처리
        List<Schedule> schedules;
        List<ScheduleGetResponse> dtos = new ArrayList<>();

        if ( author != null && !author.isEmpty()) {
            schedules = scheduleRepository.findAllByAuthorOrderByModifiedAtDesc(author);
        } else {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        }

        for (Schedule schedule : schedules) {
            ScheduleGetResponse scheduleGetResponse = new ScheduleGetResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getAuthor(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(scheduleGetResponse);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleGetResponse getOne(Long schedulesId) {
        Schedule schedule = scheduleRepository.findById(schedulesId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );

        return new ScheduleGetResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public ScheduleUpdateResponse update(Long schedulesId, ScheduleUpdateRequest request) {
        Schedule schedule = scheduleRepository.findById(schedulesId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );
        schedule.update(request.getTitle(), request.getContent(), request.getAuthor(), request.getPassword());
        return new ScheduleUpdateResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getPassword(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long schedulesId) {
        boolean existence = scheduleRepository.existsById(schedulesId);
        if(!existence){
            throw new IllegalArgumentException("없는 번호 입니다.");
        }
        scheduleRepository.deleteById(schedulesId);

    }

}
