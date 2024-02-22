package com.compassuol.sp.challenge.msnotification.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compassuol.sp.challenge.msnotification.model.Notify;
import com.compassuol.sp.challenge.msnotification.repository.NotifyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotifyService {
    
    private final NotifyRepository notifyRepository;

    @Transactional
    public Notify saveNotify(Notify notify){
    return notifyRepository.save(notify);
    }

    @Transactional(readOnly = true)
    public List<Notify> getAllDocumentsService() {
        return notifyRepository.findAll();
    }
}
