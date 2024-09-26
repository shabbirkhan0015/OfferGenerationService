package com.OfferGenerationService.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final double APR_RATE_1 = 0.1099;
    public static final double APR_RATE_2 = 0.1199;
    public static final double APR_RATE_3 = 0.1299;
    public static final double APR_RATE_4 = 0.1399;
    public static final double APR_RATE_5 = 0.1499;

    public static final int MONTH_12 = 12;
    public static final int MONTH_24 = 24;
    public static final int MONTH_36 = 36;
    public static final int MONTH_48 = 48;
    public static final int MONTH_60 = 60;

    public static List<Double> getAprsOfLoan(){
        return Arrays.asList(Constants.APR_RATE_1, Constants.APR_RATE_2,Constants.APR_RATE_3,Constants.APR_RATE_4, Constants.APR_RATE_5);
    }
    public static  List<Integer> getNumberOfMonths()
    {
        return Arrays.asList(Constants.MONTH_12, Constants.MONTH_24, Constants.MONTH_36, Constants.MONTH_48,Constants.MONTH_60);
    }

}
