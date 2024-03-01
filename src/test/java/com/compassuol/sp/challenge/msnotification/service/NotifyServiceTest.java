package com.compassuol.sp.challenge.msnotification.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.compassuol.sp.challenge.msnotification.model.Notify;
import com.compassuol.sp.challenge.msnotification.repository.NotifyRepository;

@ExtendWith(MockitoExtension.class)
public class NotifyServiceTest {

    @InjectMocks
    private NotifyService notifyService;
    @Mock
    private NotifyRepository notifyRepository;

    private Notify NOTIFY;
    private List<Notify> notfiyList;

    @BeforeEach
    public void setUp() {
        NOTIFY = new Notify("1", "email@email.com", "CREATE", "2002/02/02");
        notfiyList = new ArrayList<>();
        notfiyList.add(NOTIFY);
    }

    @Test
    public void saveNotify() {
        when(notifyRepository.save(NOTIFY)).thenReturn(NOTIFY);
        Notify savedNotify = notifyService.saveNotify(NOTIFY);
        assertEquals(NOTIFY, savedNotify);
    }

    @Test
    public void getAllNotify() {
        when(notifyRepository.findAll()).thenReturn(notfiyList);
        List<Notify> notifyList = notifyService.getAllDocumentsService();
        assertEquals(notfiyList, notifyList);
    }
}
