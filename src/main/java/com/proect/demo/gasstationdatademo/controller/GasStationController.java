package com.proect.demo.gasstationdatademo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proect.demo.gasstationdatademo.helpers.FuelPriceStatisticsResponse;
import com.proect.demo.gasstationdatademo.models.GasStation;
import com.proect.demo.gasstationdatademo.service.interfaces.IGasStationService;

@RestController
@RequestMapping("/api/v1/gas-stations")
public class GasStationController {
    @Autowired
    private IGasStationService service;
    
    @GetMapping("/search")
    public List<GasStation> getResponse(
        @RequestParam(name = "name") String name
    ) {
       return service.getGasStationByName(name); 
    }

    @GetMapping("/fuel-prices")
    public FuelPriceStatisticsResponse getFuelPriceStatistics(
            @RequestParam(name = "fuelType") String fuelType) {
        if (!service.isValidFuelType(fuelType)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid fuel type: " + fuelType);
        }

        return service.generateFuelPriceStatistic(fuelType);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
    }
}
