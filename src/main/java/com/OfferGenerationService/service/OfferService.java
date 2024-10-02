package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.model.Offer;

import java.util.List;


public interface OfferService {

    List<Offer> generateOffer(String applicationId, OfferRequest offerRequest);
    List<Offer> getOffersByApplicationId(String applicationId);

}
