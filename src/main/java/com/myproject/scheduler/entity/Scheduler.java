package com.myproject.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Scheduler {

    /**
     * Javadoc 참고해서 주석 달아보기
     * 선언하기
     */
    private Long id; // 식별자
    private Date date; // 스케줄 작성 날짜
    private String title; // 스케줄 제목
    private String contents; // 스케줄 내용
    private String name; // 작성자명


}
