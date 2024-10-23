package com.OfferGenerationService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String applicationId;
    @Id
    private String offerId;
    private Double AprRate;
    private Integer LoanAmount;
    private Double LoanAfterInterest;
    private Integer NumberofMonths;
    private Double emiAmount;
}
