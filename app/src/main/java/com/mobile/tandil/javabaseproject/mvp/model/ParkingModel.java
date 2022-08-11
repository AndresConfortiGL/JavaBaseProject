package com.mobile.tandil.javabaseproject.mvp.model;

import static com.mobile.tandil.javabaseproject.util.Constants.DEFAULT_VALUE;
import com.mobile.tandil.javabaseproject.db.ReservationDatabase;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.Model {
    private long availableParkingSpots = DEFAULT_VALUE;
    private final ReservationDatabase db;

    public ParkingModel(ReservationDatabase instance) {
        db = instance;
    }

    @Override
    public void setAvailableParkingSpots(Long availableParkingSpots) {
        this.availableParkingSpots = availableParkingSpots;
        db.setParkingLots(this.availableParkingSpots);
    }

    @Override
    public long getAvailableParkingSpots() {
        return availableParkingSpots;
    }
}
