package com.proect.demo.gasstationdatademo.service.interfaces;

import java.util.List;

import com.proect.demo.gasstationdatademo.helpers.FuelPriceStatisticsResponse;
import com.proect.demo.gasstationdatademo.models.GasStation;

public interface IGasStationService {
    public List<GasStation> getGasStationByName(String name);
    public boolean isValidFuelType(String fuelType);
    public FuelPriceStatisticsResponse generateFuelPriceStatistic(String fuelType);
}
