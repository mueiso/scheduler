package com.myproject.scheduler.controller;

import com.myproject.scheduler.dto.ScheduleRequestDto;
import com.myproject.scheduler.dto.ScheduleResponseDto;
import com.myproject.scheduler.entity.Scheduler;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Scheduler> scheduleList = new HashMap<>();

    // 1. 일정 추가
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {

        /**
         * 식별자가 중복되지 않도록 1씩 증가
         * scheduleList가 비어있으면 treu 반환 -> scheduleID에 1 할당
         * 비어있지 않으면 false 반환 -> scheduleList의 키 중 가장 큰 값에 1을 더한 값을 scheduleID에 할당
         */
        Long id = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        /**
         * 요청받은 데이터로 Schedule 객체 생성
         */
        Scheduler schedule = new Scheduler(id, dto.getTitle(), dto.getContents(), dto.getWriter());

        /**
         * Inmemory DB에 Schedule 저장
         */
        scheduleList.put(id, schedule);

        return new ScheduleResponseDto(schedule);
    }

    // 2. 일정 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long id) {

        Scheduler schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);
    }

// 3. 일정 수정
    @PutMapping("/{id}")
    public ScheduleResponseDto editScheduleById(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        Scheduler schedule = scheduleList.get(id);

        schedule.edit(dto);

        return new ScheduleResponseDto(schedule);
    }

// 4. 일정 삭제
    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleList.remove(id);  // remove 함수 사용

        return "일정 삭제 완료";

    }


}

