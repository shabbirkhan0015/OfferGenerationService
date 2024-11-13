package com.OfferGenerationService.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "offer")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Offer {
    @Id
    private String offerId;
    private Double aprRate;
    private Integer loanAmount;
    private Double loanAfterInterest;
    private Integer numberOfMonths;
    private Double emiAmount;
    private Boolean selected;
}

