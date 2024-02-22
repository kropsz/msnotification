package com.compassuol.sp.challenge.msnotification.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.compassuol.sp.challenge.msnotification.model.Notify;
import com.compassuol.sp.challenge.msnotification.web.dto.NotifyPayloadDto;

public class NotifyMapper {

    public static Notify toNotify(NotifyPayloadDto dto) {
        return new ModelMapper().map(dto, Notify.class);
    }

    public static NotifyPayloadDto tDto(Notify notify) {
        return new ModelMapper().map(notify, NotifyPayloadDto.class);
    }

    public static List<NotifyPayloadDto> toListDto(List<Notify> notifications) {
        return notifications.stream().map(notify -> tDto(notify)).collect(Collectors.toList());
    }

}
