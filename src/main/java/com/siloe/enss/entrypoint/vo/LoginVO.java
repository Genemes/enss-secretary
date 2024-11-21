package com.siloe.enss.entrypoint.vo;

import java.time.LocalDate;

public record LoginVO(String accessToken, Long expiresIn) {
    public static LoginVO with(String accessToken, Long expiresIn){
        return new LoginVO(accessToken, expiresIn);
    }
}