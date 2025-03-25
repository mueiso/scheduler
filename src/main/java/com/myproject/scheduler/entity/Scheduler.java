package com.myproject.scheduler.entity;

import com.myproject.scheduler.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Scheduler {

    /**
     * Javadoc 참고해서 주석 달아보기
     * 선언하기
     */
    private Long id;  // 식별자
    private String title;  // 스케줄 제목
    private String contents;  // 스케줄 내용
    private String writer;  // 작성자명
    private String password;  //  비밀번호
    private LocalDateTime editedAt;  // 작성 날짜 & 시간

    // 일정 수정 메서드
    public void edit(ScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.password = dto.getPassword();
    }

}
