package com.myproject.scheduler.dto;

import com.myproject.scheduler.entity.Scheduler;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String writer;

    public ScheduleResponseDto(Scheduler schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.writer = schedule.getWriter();
    }

}
