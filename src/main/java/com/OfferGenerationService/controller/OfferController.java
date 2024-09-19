package com.OfferGenerationService.controller;

import com.OfferGenerationService.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offer")
public class OfferController {


    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping("/{applicationId}")
    public void genenrateOffer(@PathVariable String applicationId, Integer loanAmount)
    {
            offerService.generateOffer(applicationId,loanAmount);
    }
}
