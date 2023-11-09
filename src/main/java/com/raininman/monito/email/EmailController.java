package com.raininman.monito.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public List<Email> getEmails() {
        return emailService.getEmails();
    }

    @PostMapping
    public void postPetItem(@RequestBody Email email) {
        emailService.addNewEmails(email);
    }

    @DeleteMapping(path = "{email}")
    public void deletePetItem(@PathVariable("email") String email) {
        emailService.deleteEmail(email);
    }
}
