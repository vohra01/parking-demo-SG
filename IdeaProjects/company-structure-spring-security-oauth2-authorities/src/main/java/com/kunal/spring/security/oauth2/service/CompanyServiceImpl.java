package com.kunal.spring.security.oauth2.service;

import com.kunal.spring.security.oauth2.model.Notification;
import com.kunal.spring.security.oauth2.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    @Transactional
    @PreAuthorize("hasAuthority('NOTIFICATIONS')")
    public void create(Notification notification) {
        companyRepository.create(notification);
    }

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('NOTIFICATIONS')")
    public List<Notification> get(Long cost) {
        return companyRepository.find(cost);
    }


    @Override
    @Transactional
    @PreAuthorize("hasAuthority('NOTIFICATIONS')")
    public Notification getNotification(Long cost) {

        Notification notification = null;
        Long id = getaMaxNotificationsGenerated(cost);

        if (cost.equals(49)) {
            notification = basicUserNotificationOperation(notification, id, cost);
        } else if (cost.equals(99)) {
            notification = midLevelUserNotificationOperation(notification, id, cost);
        } else if (cost.equals(500)) {
            notification = topLevelUserNotificationOperation(notification, id, cost);
        } else {
            return notification;
        }
        return notification;
    }

    private Long getaMaxNotificationsGenerated(Long cost) {
        return Optional.ofNullable(get(cost)).orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .map(Notification::getId)
                    .sorted(Comparator.reverseOrder()).findFirst().orElse(new Long(0));
    }

    private Notification basicUserNotificationOperation(Notification notification, Long id, Long cost) {
        if (Objects.nonNull(id) && id > 1000000) {
            notification = new Notification(new Long(id), "", "email sent", cost);
        } else {
            notification.setMessage("");
            notification.setEmail("email Sent");
            create(notification);
        }
        return notification;
    }

    private Notification midLevelUserNotificationOperation(Notification notification, Long n,Long cost) {
        if (Objects.nonNull(n) && n > 10000000) {
            notification = new Notification(new Long(n), "message sent", "email sent",cost);
        } else {
            notification.setMessage("message sent");
            notification.setEmail("email Sent");
            create(notification);
        }
        return notification;
    }

    private Notification topLevelUserNotificationOperation(Notification notification, Long n, Long cost) {
        if (Objects.nonNull(n)) {
            notification = new Notification(new Long(n), "message sent", "email sent",cost);
        } else {
            notification.setMessage("message sent");
            notification.setEmail("email Sent");
            create(notification);
        }
        return notification;
    }


}

