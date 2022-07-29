package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.Model {

    private static final long DEFAULT_VALUE = -1;
    private long availableParkingSpots = DEFAULT_VALUE;

    @Override
    public void setAvailableParkingSpots(Long availableParkingSpots) {
        this.availableParkingSpots = availableParkingSpots;
    }

    @Override
    public long getAvailableParkingSpots() {
        return availableParkingSpots;
    }
}
