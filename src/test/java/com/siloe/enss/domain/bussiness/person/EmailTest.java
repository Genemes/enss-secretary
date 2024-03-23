package com.siloe.enss.domain.bussiness.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    public void shouldReturnNPEWhenParameterIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> Email.of(null));
    }

    @Test
    public void shouldReturnIllegalWhenParameterIsNotValid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Email.of(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Email.of("email@email"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Email.of("@email.com"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Email.of("email@emailcom"));
    }

    @Test
    public void shouldReturnOkWhenEmailIsValid() {
        String validEmail = "financeiro@enss.com";

        Email result = Email.of(validEmail);

        assertNotNull(result);
    }
}