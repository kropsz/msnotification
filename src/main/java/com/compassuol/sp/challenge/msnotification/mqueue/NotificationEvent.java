package com.compassuol.sp.challenge.msnotification.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.compassuol.sp.challenge.msnotification.model.Notify;
import com.compassuol.sp.challenge.msnotification.service.NotifyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationEvent {

    private final NotifyService notifyService;

    @RabbitListener(queues = "${mq.queue.event-notification}")
    public void reciveEventNotification(@Payload String payload) throws JsonMappingException, JsonProcessingException {
        try {
            var mapper = new ObjectMapper();
            Notify notify = mapper.readValue(payload, Notify.class);
            notifyService.saveNotify(notify);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao salvar o evento de notificação.");
        }

    }
}
