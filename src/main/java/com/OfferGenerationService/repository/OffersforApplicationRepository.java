package com.OfferGenerationService.repository;

import com.OfferGenerationService.model.Offer;
import com.OfferGenerationService.model.OffersforApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersforApplicationRepository extends JpaRepository<OffersforApplication, String> {
}