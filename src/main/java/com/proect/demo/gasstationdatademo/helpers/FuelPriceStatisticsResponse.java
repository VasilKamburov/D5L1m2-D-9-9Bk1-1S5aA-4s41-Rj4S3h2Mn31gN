package com.proect.demo.gasstationdatademo.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FuelPriceStatisticsResponse {
    private double minPrice;
    private double medianPrice;
    private double maxPrice;
    private FuelType fuelType; 
}
