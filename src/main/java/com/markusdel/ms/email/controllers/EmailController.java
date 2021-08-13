package com.markusdel.ms.email.controllers;

import com.markusdel.ms.email.dtos.EmailDto;
import com.markusdel.ms.email.models.EmailModel;
import com.markusdel.ms.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@Valid @RequestBody EmailDto dto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(dto, emailModel);
        EmailModel savedEmail = emailService.sendEmail(emailModel);
        return new ResponseEntity<>(savedEmail, HttpStatus.CREATED);
    }
}
