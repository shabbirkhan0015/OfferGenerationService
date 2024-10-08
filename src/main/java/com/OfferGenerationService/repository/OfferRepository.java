package com.OfferGenerationService.repository;

import com.OfferGenerationService.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<String, Offer> {


}