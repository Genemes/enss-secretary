package com.siloe.enss.infraestructure.mappers;

import com.siloe.enss.domain.bussiness.person.Email;
import com.siloe.enss.infraestructure.presentation.EmailPresentation;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public static EmailPresentation map(Email email) {
        return EmailPresentation.of(email.toString());
    }

}
