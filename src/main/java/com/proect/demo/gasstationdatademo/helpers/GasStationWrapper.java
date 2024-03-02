package com.proect.demo.gasstationdatademo.helpers;

import java.util.List;

import com.proect.demo.gasstationdatademo.models.GasStation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GasStationWrapper {
    private List<GasStation> stations;
}
