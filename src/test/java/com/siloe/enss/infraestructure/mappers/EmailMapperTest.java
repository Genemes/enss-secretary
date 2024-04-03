package com.siloe.enss.infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.siloe.enss.domain.bussiness.person.Email;
import com.siloe.enss.infraestructure.presentation.EmailPresentation;
import org.junit.jupiter.api.Test;

public class EmailMapperTest {

    @Test
    public void mapValidEmailReturnsEmailPresentation() {
        // Given
        String validEmail = "test@example.com";
        Email email = Email.of(validEmail);

        // When
        EmailPresentation presentation = EmailMapper.map(email);

        // Then
        assertEquals(validEmail, presentation.toString());
    }

    @Test
    public void mapNullEmailThrowsNullPointerException() {
        // Given
        Email email = null;

        // Then
        assertThrows(NullPointerException.class, () -> EmailMapper.map(email));
    }
}
