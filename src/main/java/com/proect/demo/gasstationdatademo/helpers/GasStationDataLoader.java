package com.proect.demo.gasstationdatademo.helpers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.proect.demo.gasstationdatademo.models.GasStation;
import com.proect.demo.gasstationdatademo.repository.IGasStationRepository;
import jakarta.annotation.PostConstruct;

@Component
public class GasStationDataLoader {
    private static final String GAS_STATIONS_URL = "https://wejago.de/assets/data/gas-stations-data.json";

    @Autowired
    private IGasStationRepository gasStationRepository;

    @PostConstruct
    public void loadAndPersistGasStations() {
        gasStationRepository.deleteAll();

        RestTemplate restTemplate = new RestTemplate();
        GasStationWrapper wrapper = restTemplate.getForObject(GAS_STATIONS_URL, GasStationWrapper.class);

        if (wrapper != null && wrapper.getStations() != null) {
            List<GasStation> openGasStations = wrapper.getStations().stream()
                    .filter(station -> station.getIsOpen())
                    .collect(Collectors.toList());

            gasStationRepository.saveAll(openGasStations);

        }
    }
}
