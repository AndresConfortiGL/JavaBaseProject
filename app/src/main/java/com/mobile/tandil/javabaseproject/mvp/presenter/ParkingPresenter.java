package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;

public class ParkingPresenter implements ParkingContract.Presenter {

    private final ParkingContract.Model parkingModel;
    private final ParkingContract.View parkingView;
    private final int testValue = 99;

    public ParkingPresenter(ParkingContract.Model parkingModel, ParkingContract.View parkingView) {
        this.parkingModel = parkingModel;
        this.parkingView = parkingView;
    }

    @Override
    public void showAvailableParkingSpots(){
        parkingModel.setAvailableParkingSpots(testValue);
        parkingView.displayAvailableParkingSpots(String.valueOf(parkingModel.getAvailableParkingSpots()));
    }
}
