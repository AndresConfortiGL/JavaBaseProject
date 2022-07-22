package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingModel implements ParkingContract.Model {

    private static final int DEFAULT_VALUE = -1;
    private int availableParkingSpots = DEFAULT_VALUE;

    @Override
    public void setAvailableParkingSpots(int availableParkingSpots){
        this.availableParkingSpots = availableParkingSpots;
    }

    @Override
    public int getAvailableParkingSpots(){
        return availableParkingSpots;
    }
}
