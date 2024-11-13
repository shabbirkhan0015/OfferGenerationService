package com.OfferGenerationService.controller;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.Request.OfferUpdateRequest;
import com.OfferGenerationService.model.Offer;
import com.OfferGenerationService.model.OffersforApplication;
import com.OfferGenerationService.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
@CrossOrigin(origins = "*")
public class OfferController {


    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping("/{applicationId}")
    public List<Offer> genenrateOffer(@PathVariable String applicationId, @RequestBody OfferRequest offerRequest) {


        return offerService.generateOffer(applicationId, offerRequest);
    }
    @GetMapping("/{applicationId}")
    public List<Offer> getOffersByApplicationId(@PathVariable String applicationId){
        return offerService.getOffersByApplicationId(applicationId);
    }
    @PostMapping
    public ResponseEntity<OffersforApplication> SaveOffers(@RequestBody OfferUpdateRequest offer) {
        OffersforApplication savedOffers = offerService.saveOffersForApplication(offer);
        return ResponseEntity.ok(savedOffers);
    }
}