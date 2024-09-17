package com.OfferGenerationService.helper;


public class VintageScore {

    public int calculateVintage(Integer grossIncome, Integer loanAmount)
    {
        int loanIncomePercentage = (loanAmount * 100) / grossIncome;
        int vintageScore = 0;

        if (loanIncomePercentage < 10) {
            vintageScore = 1;
        } else if (loanIncomePercentage >= 10 && loanIncomePercentage < 20) {
            vintageScore = 2;
        } else if (loanIncomePercentage >= 20 && loanIncomePercentage < 30) {
            vintageScore = 3;
        } else if (loanIncomePercentage >= 30 && loanIncomePercentage < 40) {
            vintageScore = 4;
        } else if (loanIncomePercentage >= 40 && loanIncomePercentage < 50) {
            vintageScore = 5;
        } else if (loanIncomePercentage >= 50 && loanIncomePercentage < 60) {
            vintageScore = 6;
        } else if (loanIncomePercentage >= 60 && loanIncomePercentage < 70) {
            vintageScore = 7;
        } else if (loanIncomePercentage >= 70 && loanIncomePercentage < 80) {
            vintageScore = 8;
        } else if (loanIncomePercentage >= 80 && loanIncomePercentage < 90) {
            vintageScore = 9;
        }  else {
            vintageScore = 10;
        }
        return vintageScore;
    }

}
