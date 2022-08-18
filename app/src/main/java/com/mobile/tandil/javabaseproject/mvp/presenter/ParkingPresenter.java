package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.util.Constants;

public class ParkingPresenter implements ParkingContract.Presenter {
    private final ParkingContract.Model parkingModel;
    private final ParkingContract.View parkingView;

    public ParkingPresenter(ParkingContract.Model parkingModel, ParkingContract.View parkingView) {
        this.parkingModel = parkingModel;
        this.parkingView = parkingView;
    }

    @Override
    public void showFragment(ListenerDialogFragment listener) {
            parkingView.displayFragment(listener);
    }

    @Override
    public void showAvailableParkingSpots(Long value) {
        parkingModel.setAvailableParkingSpots(value);
        parkingView.displayAvailableParkingSpots(parkingModel.getAvailableParkingSpots());
    }

    @Override
    public void showReserverActivity() {
        if (parkingModel.getAvailableParkingSpots() > Constants.MIN_LIMIT) {
            parkingView.displayReserverActivity();
        } else {
            parkingView.displayToastNoSpace();
        }
    }
}
