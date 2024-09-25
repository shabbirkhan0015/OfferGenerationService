package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.helper.CVPL;
import com.OfferGenerationService.helper.RiskMatrix;
import com.OfferGenerationService.helper.VintageScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private CVPL cvpl;

    @Autowired
    private VintageScore vintageScore;

    @Autowired
    private RiskMatrix riskMatrix;

    private Integer cvplIndex;
    private Integer cvplScore;
    private Integer vintageScoreResult ;
    private Integer riskIndicator;


    @Override
    public void generateOffer(String applicationId, OfferRequest offerRequest) {

        Map<String , Integer> cvplMap = cvpl.calculateCVPL(offerRequest.getGrossIncome());
        if(!cvplMap.isEmpty())
        {
            cvplScore= cvplMap.get("cvplScore");
            cvplIndex = cvplMap.get("cvplIndex");
        }
        vintageScoreResult =  vintageScore.calculateVintage(offerRequest.getGrossIncome(),offerRequest.getLoanAmount());
        riskIndicator = riskMatrix.getRiskValue(cvplIndex-1, vintageScoreResult-1);


    }

}
