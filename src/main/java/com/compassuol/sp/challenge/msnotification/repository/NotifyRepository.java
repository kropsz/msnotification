package com.compassuol.sp.challenge.msnotification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassuol.sp.challenge.msnotification.model.Notify;

public interface NotifyRepository extends JpaRepository<Notify, Long>{
    
}
