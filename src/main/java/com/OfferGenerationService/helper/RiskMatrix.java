package com.OfferGenerationService.helper;

public class RiskMatrix {
    private final int[][] matrix = {
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {1, 2, 3, 4, 5, 6, 7, 8, 9}
    };


    public int getRiskValue(int row, int col) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            return matrix[row][col];
        } else {
            throw new IllegalArgumentException("Row and column must be between 0 and 8.");
        }
    }
}
