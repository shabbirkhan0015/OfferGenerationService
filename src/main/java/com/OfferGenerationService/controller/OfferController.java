package com.OfferGenerationService.controller;

import com.OfferGenerationService.Request.OfferRequest;
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
    public void genenrateOffer(@PathVariable String applicationId, @RequestBody OfferRequest offerRequest)
    {
            offerService.generateOffer(applicationId,offerRequest);
    }
}
