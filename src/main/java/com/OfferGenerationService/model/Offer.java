package com.OfferGenerationService.model;


import jakarta.persistence.Entity;
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
    private Double Apr;
    private Integer LoanAmount;
    private Integer LoanAfterInterest;
    private Integer NumberofMonths;
    private Double emiAmount;
    private Double aprRtate;

}
