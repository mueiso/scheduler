package com.myproject.scheduler.controller;

import com.myproject.scheduler.dto.ScheduleRequestDto;
import com.myproject.scheduler.dto.ScheduleResponseDto;
import com.myproject.scheduler.entity.Scheduler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ScheduleController {

    private final Map<Long, Scheduler> scheduleList = new HashMap<>();

    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {

        /**
         * 식별자가 중복되지 않도록 1씩 증가
         * scheduleList가 비어있으면 treu 반환 -> scheduleID에 1 할당
         * 비어있지 않으면 false 반환 -> scheduleList의 키 중 가장 큰 값에 1을 더한 값을 scheduleID에 할당
         */
        Long scheduleID = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        /**
         * 요청받은 데이터로 Schedule 객체 생성
         */
        new Scheduler(scheduleID, dto.getDate(), dto.getTitle(), dto.getContents(), dto.getName());

        /**
         * Inmemory DB에 Schedule 저장
         */
    }

}
