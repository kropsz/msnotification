package com.compassuol.sp.challenge.msnotification.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.compassuol.sp.challenge.msnotification.model.Notify;
import com.compassuol.sp.challenge.msnotification.service.NotifyService;
import com.compassuol.sp.challenge.msnotification.web.controller.NotifyController;


@WebMvcTest(NotifyController.class)
public class NotifyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotifyService notifyService;

    @Test
    public void getAllNotificationsTest() throws Exception {
        Notify notify1 = new Notify("1","email1", "message1", "date");
        Notify notify2 = new Notify("2","email2", "message2", "date");
        List<Notify> notifyList = Arrays.asList(notify1, notify2);

        when(notifyService.getAllDocumentsService()).thenReturn(notifyList);

        String expectedJson = "[{\"email\":\"email1\",\"event\":\"message1\",\"date\":\"date\"}," +
                          "{\"email\":\"email2\",\"event\":\"message2\",\"date\":\"date\"}]";

    mockMvc.perform(get("/notify"))
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
    }
}