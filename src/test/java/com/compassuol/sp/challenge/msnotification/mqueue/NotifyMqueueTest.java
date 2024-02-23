package com.compassuol.sp.challenge.msnotification.mqueue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.compassuol.sp.challenge.msnotification.model.Notify;
import com.compassuol.sp.challenge.msnotification.service.NotifyService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotifyMqueueTest {

    @Mock
    NotifyService notifyService;

    @InjectMocks
    NotificationEvent notificationEvent;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReciveEventNotification() throws Exception {
        String payload = "{\n" +
                "    \"email\": \"email@email.com\",\n" +
                "    \"event\": \"CREATE\",\n" +
                "    \"date\": \"1990/12/10\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Notify notify = mapper.readValue(payload, Notify.class);

        when(notifyService.saveNotify(any(Notify.class))).thenReturn(notify);

        notificationEvent.reciveEventNotification(payload);

        verify(notifyService, times(1)).saveNotify(notify);
    }
}
