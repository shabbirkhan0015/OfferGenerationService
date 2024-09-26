package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.constants.Constants;
import com.OfferGenerationService.helper.RiskCalculator;
import com.OfferGenerationService.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {


    @Autowired
    private RiskCalculator riskCalculator;
    private Integer riskIndicator;


    @Override
    public void generateOffer(String applicationId, OfferRequest offerRequest) {
        List<Offer> offers = new ArrayList<>();
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
                (apr, month) -> calculateOffer(apr, month, offerRequest.getLoanAmount())
        ).toList();

        offerList.forEach(System.out::println);
    }

    public Offer calculateOffer(Double apr, Integer month, Integer loanAmount) {
        Offer offer = new Offer();
        Double rate = apr / 12;
        Double aprConst = Math.pow((1 + rate), month);
        Double monthlyPayback = (loanAmount * rate * aprConst) / (aprConst - 1);
        offer.setEmiAmount(monthlyPayback);
        return offer;
    }

}
