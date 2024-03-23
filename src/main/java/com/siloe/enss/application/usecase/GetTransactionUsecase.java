package com.siloe.enss.application.usecase;

import org.springframework.stereotype.Service;

@Service
public class GetTransactionUsecase {
    /*
    private final OnboardGateway gateway;

    private final OnboardMapper mapper;

    public GetOnboardUseCase(OnboardGateway gateway, OnboardMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

    public OnboardVO execute(String healthCard, String funcionality) {
        if (healthCard == null || funcionality == null) {
            log.info("parameters cannot be null!");
            throw new IllegalArgumentException("invalid argument");
        }

        Onboard savedOnboard = gateway.getOnboarding(healthCard, funcionality);

        log.info("M=getOnboard, message=UseCase, onboard return successfully, id={}", savedOnboard);

        return mapper.map(savedOnboard);
    }
    */
}
