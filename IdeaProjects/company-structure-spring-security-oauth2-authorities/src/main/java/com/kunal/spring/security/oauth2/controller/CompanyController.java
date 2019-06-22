package com.kunal.spring.security.oauth2.controller;

import com.kunal.spring.security.oauth2.model.Notification;
import com.kunal.spring.security.oauth2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secured/company/notifications")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/subscription/{cost}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> sendNotifications(@PathVariable Long cost) {
        Notification notification = new Notification();
        if (cost.equals(49) || cost.equals(99) || cost.equals(500)) {
            notification = companyService.getNotification(cost);
            return new ResponseEntity<>(notification, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(notification, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}