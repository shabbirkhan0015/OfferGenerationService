package com.OfferGenerationService.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @GetMapping("/{applicationId}")
    public void genenrateOffer(@PathVariable String applicationId, Integer LoanAmount)
    {

    }
}
