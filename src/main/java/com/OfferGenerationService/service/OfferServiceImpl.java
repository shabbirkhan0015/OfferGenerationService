package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.constants.Constants;
import com.OfferGenerationService.helper.RiskCalculator;
import com.OfferGenerationService.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private RiskCalculator riskCalculator;
    private Integer riskIndicator;


    @Override
    public List<Offer> generateOffer(String applicationId, OfferRequest offerRequest) {

        riskIndicator = riskCalculator.calculateRisk(offerRequest);
//        if(riskIndicator == 9)
//        {
//            return;
//        }

        List<Double> aprs = Constants.getAprsOfLoan();
        List<Integer> months = Constants.getNumberOfMonths();

        List<Offer> offerList = StreamUtils.zip(
                aprs.stream(),
                months.stream(),
                (apr, month) -> calculateOffer(apr, month, offerRequest.getLoanAmount(), applicationId)
        ).toList();

        return  offerList;
    }

    public Offer calculateOffer(Double apr, Integer month, Integer loanAmount, String applicationId) {
        Offer offer = new Offer();
        Double rate = apr / 12;
        int i =1;
        Double aprConst = Math.pow((1 + rate), month);
        double monthlyPayback = (loanAmount * rate * aprConst) / (aprConst - 1);
        monthlyPayback = Math.round(monthlyPayback * 100.0) / 100.0;


        double loanAfterInterest = monthlyPayback * month;


        loanAfterInterest = Math.round(loanAfterInterest * 100.0) / 100.0;
        offer.setEmiAmount(monthlyPayback);
        offer.setApplicationId(applicationId);
        offer.setOfferId(i++);
        offer.setAprRate(apr);
        offer.setLoanAmount(loanAmount);
        offer.setNumberofMonths(month);
        offer.setLoanAfterInterest(loanAfterInterest);
        return offer;
    }

}
