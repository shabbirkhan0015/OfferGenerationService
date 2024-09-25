package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface OfferService {

    public void generateOffer(String applicationId, OfferRequest offerRequest);

}
