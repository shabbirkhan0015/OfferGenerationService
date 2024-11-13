package com.OfferGenerationService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "offersforapplication")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OffersforApplication {
    @Id
    private String applicationId;

    // Unidirectional One-to-Many relationship with Offer
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "applicationid") // Creates a foreign key in Offer table
    private List<Offer> offers;
}