package com.siloe.enss.domain.bussiness.person;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    public static Email of(String email){
        Objects.requireNonNull(email, "email is required");
        if(!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return new Email(email);
    }

    /**
     * Create a valid instace of email
     * @param email a text of will validate
     * @return a email instance
     * @throws NullPointerException when parameter is null
     * @throws IllegalArgumentException when string is not valid
     * */
    private static boolean isValidEmail(String email) {
        // RFC-5322
        String EMAIL_PATTERN = "^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z](?:[A-Za-z0-9-]*[A-Za-z0-9])+$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public String toString() {
        return value;
    }
}
