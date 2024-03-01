package com.compassuol.sp.challenge.msnotification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.compassuol.sp.challenge.msnotification.model.Notify;

public interface NotifyRepository extends MongoRepository<Notify, String> {

}
