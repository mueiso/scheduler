package com.myproject.scheduler.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {


    private String title;
    private String contents;

    @NotNull(message = "작성자명은 필수로 입력해야 합니다.")
    private String writer;

    @NotNull(message = "비밀번호는 필수로 입력해야 합니다.")
    private String password;

}
