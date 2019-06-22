package com.kunal.spring.security.oauth2.service;

import com.kunal.spring.security.oauth2.model.Notification;

import java.util.List;

public interface CompanyService {


    Notification getNotification(Long cost);

    List<Notification> get(Long cost);

    void create(Notification notification);

}
