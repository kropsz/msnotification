package com.compassuol.sp.challenge.msnotification.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compassuol.sp.challenge.msnotification.service.NotifyService;
import com.compassuol.sp.challenge.msnotification.web.dto.NotifyPayloadDto;
import com.compassuol.sp.challenge.msnotification.web.dto.mapper.NotifyMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotifyController {

    private final NotifyService notifyService;

    @GetMapping()
    public ResponseEntity<List<NotifyPayloadDto>> getAllNotifications() {
        var notifications = notifyService.getAllDocumentsService();
        return ResponseEntity.status(HttpStatus.OK).body(NotifyMapper.toListDto(notifications));
    }
}
