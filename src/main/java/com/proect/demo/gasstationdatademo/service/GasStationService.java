package com.proect.demo.gasstationdatademo.service;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proect.demo.gasstationdatademo.helpers.FuelPriceStatisticsResponse;
import com.proect.demo.gasstationdatademo.helpers.FuelType;
import com.proect.demo.gasstationdatademo.models.GasStation;
import com.proect.demo.gasstationdatademo.repository.IGasStationRepository;
import com.proect.demo.gasstationdatademo.service.interfaces.IGasStationService;

@Service
public class GasStationService implements IGasStationService {
    @Autowired
    private IGasStationRepository repository;

    @Override
    public List<GasStation> getGasStationByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public FuelPriceStatisticsResponse generateFuelPriceStatistic(String fuelType) {
        List<Double> fuelPrices = repository.findPricesByFuelType(fuelType.toLowerCase());
        
        Double median =  calculateMedian(fuelPrices);
        if (median == null) {
            return new FuelPriceStatisticsResponse(0, 0, 0, FuelType.valueOf(fuelType.toUpperCase()));
        }
        FuelPriceStatisticsResponse newResponse = new FuelPriceStatisticsResponse(fuelPrices.get(0),
        median, fuelPrices.get(fuelPrices.size() - 1), FuelType.valueOf(fuelType.toUpperCase()));
        return newResponse;
    }

    @Override
    public boolean isValidFuelType(String fuelType) {
        return EnumUtils.isValidEnumIgnoreCase(FuelType.class, fuelType);
    }

    public Double calculateMedian(List<Double> fuelPrices) {
        if (fuelPrices == null || fuelPrices.isEmpty()) {
            return null;
        }

        int size = fuelPrices.size();
        // If size is odd, median is the middle element
        if (size % 2 != 0) {
            return fuelPrices.get(size / 2);
        } else {
            // If size is even, calculate median as the average of middle two elements
            int middleIndex = size / 2;
            return (fuelPrices.get(middleIndex - 1) + fuelPrices.get(middleIndex)) / 2.0;
        }
    }

}
