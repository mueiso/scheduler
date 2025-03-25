package com.myproject.scheduler.dto;

import com.myproject.scheduler.entity.Scheduler;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String writer;
    private LocalDateTime editedAt;

    public ScheduleResponseDto(Scheduler schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.writer = schedule.getWriter();
        this.editedAt = schedule.getEditedAt();
    }

}
