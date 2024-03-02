package com.proect.demo.gasstationdatademo.models;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GasStation {
    @Id
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

    @Column(nullable = false)
    private double dist;

    @Column(nullable = false)
    private double diesel;

    @Column(nullable = false)
    private double e5;

    @Column(nullable = false)
    private double e10;

    @Column(nullable = false)
    private Boolean isOpen;

    @Column(nullable = false)
    private String houseNumber;

    @Column(nullable = false)
    private int postCode;
}
