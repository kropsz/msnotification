package com.compassuol.sp.challenge.msnotification.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NotifyPayloadDto {
    private String email;
    private String event;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String date;
}
