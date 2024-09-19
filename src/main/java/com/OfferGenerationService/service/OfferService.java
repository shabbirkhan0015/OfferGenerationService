package com.OfferGenerationService.service;

import org.springframework.stereotype.Service;


public interface OfferService {
    public void generateOffer(String applicationId, Integer LoanAmount);

}
