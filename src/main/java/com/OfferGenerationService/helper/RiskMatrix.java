package com.OfferGenerationService.helper;

import org.springframework.stereotype.Component;

@Component
public class RiskMatrix {
    private final int[][] matrix = {
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {9, 8, 7, 6, 5, 4, 3, 2, 1}
    };

    public int getRiskValue(int row, int col) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            return matrix[row][col];
        } else {
            throw new IllegalArgumentException("Row and column must be between 0 and 8.");
        }
    }
}
