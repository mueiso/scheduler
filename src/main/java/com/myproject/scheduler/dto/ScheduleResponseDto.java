package com.myproject.scheduler.dto;

import com.myproject.scheduler.entity.Scheduler;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String writer;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ScheduleResponseDto(Scheduler schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.writer = schedule.getWriter();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

}
