package com.proect.demo.gasstationdatademo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proect.demo.gasstationdatademo.models.GasStation;

@Repository
public interface IGasStationRepository extends JpaRepository<GasStation, UUID> {
    List<GasStation> findByNameContainingIgnoreCase(String name);

    @Query("SELECT CASE " +
                "WHEN :fuelType = 'e5' THEN gs.e5 " +
                "WHEN :fuelType = 'e10' THEN gs.e10 " +
                "WHEN :fuelType = 'diesel' THEN gs.diesel " +
                "ELSE null " +
            "END " +
            "FROM GasStation gs " +
            "ORDER BY CASE " +
                "WHEN :fuelType = 'e5' THEN gs.e5 " +
                "WHEN :fuelType = 'e10' THEN gs.e10 " +
                "WHEN :fuelType = 'diesel' THEN gs.diesel " +
                "ELSE null " +
            "END ASC")
    List<Double> findPricesByFuelType(@Param("fuelType") String fuelType);

}
