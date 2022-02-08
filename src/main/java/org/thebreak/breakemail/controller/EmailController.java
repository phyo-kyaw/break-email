package org.thebreak.breakemail.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thebreak.breakemail.service.EmailService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/email")
public class EmailController {
    // test text
    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/sendBookingNotification")
    public ResponseEntity<Void> sendBookingNotificationEmail(@PathVariable String toAddress, @PathVariable String name) {
        System.out.println("email get called!");
        emailService.sendNotificationEmail(toAddress, name);
        return  new ResponseEntity(HttpStatus.OK);
    }


}
