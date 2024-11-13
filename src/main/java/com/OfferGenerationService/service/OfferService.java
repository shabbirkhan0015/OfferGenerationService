package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.Request.OfferUpdateRequest;
import com.OfferGenerationService.model.Offer;
import com.OfferGenerationService.model.OffersforApplication;

import java.util.List;


public interface OfferService {

    List<Offer> generateOffer(String applicationId, OfferRequest offerRequest);
    List<Offer> getOffersByApplicationId(String applicationId);
    OffersforApplication saveOffersForApplication(OfferUpdateRequest offer);
}
