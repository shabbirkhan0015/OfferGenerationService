package com.OfferGenerationService.helper;

import java.util.HashMap;
import java.util.Map;

public class CVPL {

    private final Map<String, Integer> cvplMap;

    public CVPL(Map<String, Integer> cvplMap) {
        this.cvplMap = cvplMap;
    }

    public Map<String, Integer> calculateCVPL(Integer grossIncome)
    {
        int cvplScore=0;
        int cvplIndex = 0;

        if (grossIncome < 30000) {
            cvplScore =600;
            cvplIndex = 1;
        }
        else if (grossIncome >= 30000 && grossIncome < 40000) {
            cvplScore =620;
            cvplIndex = 2;
        }
        else if (grossIncome >= 40000 && grossIncome < 50000) {
            cvplScore =640;
            cvplIndex = 3;
        }
        else if (grossIncome >= 50000 && grossIncome < 60000) {
            cvplScore = 660;
            cvplIndex = 4;
        }
        else if (grossIncome >= 60000 && grossIncome < 70000) {
            cvplScore = 680;
            cvplIndex =  5;
        }
        else if (grossIncome >= 70000 && grossIncome < 80000) {
            cvplScore = 700;
            cvplIndex = 6;
        }
        else if (grossIncome >= 80000 && grossIncome < 90000) {
            cvplScore = 720;
            cvplIndex = 7;
        }
        else if (grossIncome >= 90000 && grossIncome <= 100000) {
            cvplScore = 740;
            cvplIndex = 8 ;
        }
        else {
            cvplScore = 800;
            cvplIndex = 9;
        }
        cvplMap.put("cvplScore", cvplScore);
        cvplMap.put("cvplIndex",cvplIndex);
        return  cvplMap;

    }

}
