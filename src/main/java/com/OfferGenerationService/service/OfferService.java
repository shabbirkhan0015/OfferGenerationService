package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.model.Offer;

import java.util.List;


public interface OfferService {

    public List<Offer> generateOffer(String applicationId, OfferRequest offerRequest);

}
