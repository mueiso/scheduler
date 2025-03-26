package com.myproject.scheduler.controller;

import com.myproject.scheduler.dto.ScheduleRequestDto;
import com.myproject.scheduler.dto.ScheduleResponseDto;
import com.myproject.scheduler.entity.Scheduler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final Map<Long, Scheduler> scheduleList = new HashMap<>();

    // 1. 일정 추가 API
    @PostMapping
    public ScheduleResponseDto createSchedule(@Valid @RequestBody ScheduleRequestDto dto) {

        /**
         * 식별자가 중복되지 않도록 1씩 증가
         * scheduleList 가 비어있으면 true 반환 -> scheduleID에 1 할당
         * 비어있지 않으면 false 반환 -> scheduleList 의 키 중 가장 큰 값에 1을 더한 값을 scheduleID에 할당
         */
        Long id = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        /**
         * 요청받은 데이터로 Schedule 객체 생성
         */
        Scheduler schedule = new Scheduler(id, dto.getTitle(), dto.getContents(), dto.getWriter(), dto.getPassword(), LocalDateTime.now());

        /**
         * Inmemory DB에 Schedule 저장
         */
        scheduleList.put(id, schedule);

        return new ScheduleResponseDto(schedule);
    }

    // 2. 일정 단일 조회 API
    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long id) {

        Scheduler schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);
    }

    // 3. 일정 목록 조회 API
    @GetMapping
    public List<ScheduleResponseDto> showAllSchedules() {

        List<ScheduleResponseDto> scheduleResponseList = new ArrayList<>();

        for(Scheduler scheduler : scheduleList.values()) {
            scheduleResponseList.add(new ScheduleResponseDto(scheduler));
        }

        return scheduleResponseList;
    }

    // 4. 일정 단일 (전체)수정 API
    @PutMapping("/{id}")
    public ScheduleResponseDto editScheduleById(@Valid @PathVariable Long id, @RequestBody ScheduleRequestDto dto) {

        Scheduler schedule = scheduleList.get(id);

        if(schedule.getPassword().equals(dto.getPassword())) {

            schedule.edit(dto);
        } else {
            System.out.println("비밀번호가 다릅니다.");
        }

        return new ScheduleResponseDto(schedule);
    }

    // 5. 일정 삭제 API
    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id, @RequestBody String password) {

        Scheduler schedule = scheduleList.get(id);

        if(schedule.getPassword().equals(password)) {

            scheduleList.remove(id);  // remove 함수 사용

            System.out.println("삭제되었습니다.");
        } else {

            return "비밀번호가 다릅니다.";
        }

        return "일정 삭제 완료";
    }

}