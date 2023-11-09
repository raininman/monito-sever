package com.raininman.monito.email;


import jakarta.persistence.*;

@Entity
@Table
public class Email {
    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_sequence"
    )

    private Long id;
    private String email;

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public Email(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
