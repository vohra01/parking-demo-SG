package com.kunal.spring.security.oauth2.repository;

import com.kunal.spring.security.oauth2.model.Notification;

import java.util.List;

public interface CompanyRepository {

    List<Notification> find(Long cost);

    void create(Notification notification);

}
