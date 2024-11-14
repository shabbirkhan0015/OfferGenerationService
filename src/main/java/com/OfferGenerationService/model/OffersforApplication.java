package com.OfferGenerationService.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<Offer> offers;
}