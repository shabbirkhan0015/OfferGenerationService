package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.helper.CVPL;
import com.OfferGenerationService.helper.RiskCalculator;
import com.OfferGenerationService.helper.RiskMatrix;
import com.OfferGenerationService.helper.VintageScore;
import com.OfferGenerationService.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OfferServiceImpl implements OfferService {


    @Autowired
    private RiskCalculator riskCalculator;
    private Integer riskIndicator;


    @Override
    public void generateOffer(String applicationId, OfferRequest offerRequest) {
        List<Offer> offers=new ArrayList<>();
        riskIndicator = riskCalculator.calculateRisk(offerRequest);
        if(riskIndicator == 9)
        {
            return;
        }




    }

}
