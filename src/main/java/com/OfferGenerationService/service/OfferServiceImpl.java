package com.OfferGenerationService.service;

import com.OfferGenerationService.Request.OfferRequest;
import com.OfferGenerationService.Request.OfferUpdateRequest;
import com.OfferGenerationService.constants.Constants;
import com.OfferGenerationService.helper.RiskCalculator;
import com.OfferGenerationService.model.Offer;
import com.OfferGenerationService.model.OffersforApplication;
import com.OfferGenerationService.repository.OffersforApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private RiskCalculator riskCalculator;
    private Integer riskIndicator;
    private List<Offer> offers;
    @Autowired
    private  OffersforApplicationRepository offersforApplicationRepository;


    @Override
    public List<Offer> generateOffer(String applicationId, OfferRequest offerRequest) {

        riskIndicator = riskCalculator.calculateRisk(offerRequest);
        List<Double> aprs = Constants.getAprsOfLoan();
        List<Integer> months = Constants.getNumberOfMonths();

        offers = StreamUtils.zip(
                aprs.stream(),
                months.stream(),
                (apr, month) -> calculateOffer(apr, month, offerRequest.getLoanAmount(), applicationId)
        ).toList();

        return  offers;
    }

    public Offer calculateOffer(Double apr, Integer month, Integer loanAmount, String applicationId) {
        Offer offer = new Offer();
        String offerId = UUID.randomUUID().toString().substring(0,7);
        Double rate = apr / 12;
        Double aprConst = Math.pow((1 + rate), month);
        double monthlyPayback = (loanAmount * rate * aprConst) / (aprConst - 1);
        monthlyPayback = Math.round(monthlyPayback * 100.0) / 100.0;

        double loanAfterInterest = monthlyPayback * month;


        loanAfterInterest = Math.round(loanAfterInterest * 100.0) / 100.0;
        offer.setEmiAmount(monthlyPayback);
        offer.setOfferId(offerId);
        offer.setAprRate(apr);
        offer.setLoanAmount(loanAmount);
        offer.setNumberOfMonths(month);
        offer.setLoanAfterInterest(loanAfterInterest);
        return offer;
    }

    @Override
    public List<Offer> getOffersByApplicationId(String applicationId){
        return offers;
    }



    @Transactional
    public OffersforApplication saveOffersForApplication(OfferUpdateRequest offers) {
        OffersforApplication offersforApplication=new OffersforApplication();
        offersforApplication.setApplicationId(offers.getApplicationId());
        offersforApplication.setOffers(offers.getOffer());
        return offersforApplicationRepository.save(offersforApplication);
    }

}
