package com.compassuol.sp.challenge.msnotification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notify")
public class Notify {

    @Id
    private String id;
    private String email;
    private String event;
    private String date;
}
