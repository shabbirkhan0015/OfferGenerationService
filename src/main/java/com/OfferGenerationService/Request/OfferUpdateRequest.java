package com.OfferGenerationService.Request;

import com.OfferGenerationService.model.Offer;
import lombok.Data;

import java.util.List;

@Data
public class OfferUpdateRequest {
    private String applicationId;
    private List<Offer> offer;
}
