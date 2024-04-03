package com.siloe.enss.infraestructure.presentation;

import com.siloe.enss.domain.bussiness.person.Email;
import com.siloe.enss.infraestructure.mappers.EmailMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class EmailPresentation {

    private String value;

    public EmailPresentation(){}
    private EmailPresentation(String value) {
        this.value = value;
    }

    public static EmailPresentation of(String value){
        Email email = Email.of(value);
        return new EmailPresentation(email.toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
