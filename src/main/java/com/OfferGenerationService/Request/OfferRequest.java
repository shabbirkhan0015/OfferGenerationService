package com.OfferGenerationService.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfferRequest {

    private Integer loanAmount;
    private Integer grossIncome;

}
