package com.myproject.scheduler.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private Date date;
    private String title;
    private String contents;
    private String name;

}
