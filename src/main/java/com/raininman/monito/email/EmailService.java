package com.raininman.monito.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

    public void addNewEmails(Email email) {
        Optional<Email> emailByEmail = emailRepository.findEmailByEmail(email.getEmail());
        if (emailByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        emailRepository.save(email);
    }

    public void deleteEmail(String email) {
        Optional<Email> optional = emailRepository.findEmailByEmail(email);
        if (!optional.isPresent()) {
            throw new IllegalStateException("Email  " + email + " not found");

        }
        emailRepository.deleteById(optional.get().getId());
    }


}
