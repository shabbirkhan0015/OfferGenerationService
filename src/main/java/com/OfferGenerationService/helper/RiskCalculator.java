package com.OfferGenerationService.helper;

import com.OfferGenerationService.Request.OfferRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class RiskCalculator {

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

    public int calculateRisk(OfferRequest offerRequest){
        Map<String , Integer> cvplMap = cvpl.calculateCVPL(offerRequest.getGrossIncome());
        if(!cvplMap.isEmpty())
        {
            cvplScore= cvplMap.get("cvplScore");
            cvplIndex = cvplMap.get("cvplIndex");
        }
        vintageScoreResult =  vintageScore.calculateVintage(offerRequest.getGrossIncome(),offerRequest.getLoanAmount());
        riskIndicator = riskMatrix.getRiskValue(cvplIndex-1, vintageScoreResult-1);
        return riskIndicator;
    }
}
