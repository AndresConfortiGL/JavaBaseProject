package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.entity.Reservation;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ReserverContract;
import com.mobile.tandil.javabaseproject.mvp.model.ReserverModel;
import com.mobile.tandil.javabaseproject.util.ValidationEnums;
import java.util.Calendar;

public class ReserverPresenter implements ReserverContract.Presenter {
    private final ReserverContract.View reserverView;
    private final ReserverContract.Model reserverModel;

    public ReserverPresenter(ReserverContract.View reserverView, ReserverModel reserverModel) {
        this.reserverView = reserverView;
        this.reserverModel = reserverModel;
    }

    @Override
    public void returnToMainActivity() {
        reserverView.finishReserverActivity();
    }

    @Override
    public void showCheckInDateFragment(ListenerPickerFragment listener) {
        reserverModel.isCheckIn(true);
        reserverView.displayDatePicker(listener);
    }

    @Override
    public void showCheckOutDateFragment(ListenerPickerFragment listener) {
        reserverModel.isCheckIn(false);
        reserverView.displayDatePicker(listener);
    }

    @Override
    public void saveDateListener(Calendar date, ListenerPickerFragment listener) {
            reserverModel.saveDateDataFragment(date);
            reserverView.displayTimePicker(listener);
    }

    @Override
    public void saveTimeListener(Calendar time) {
            reserverModel.saveTimeDataFragment(time);
    }

    @Override
    public void saveParkingData(String parkingLot, String securityCode) {
        if (!parkingLot.isEmpty() || !securityCode.isEmpty()) {
            reserverModel.setParkingData(Integer.parseInt(parkingLot), securityCode);
            validateData(reserverModel.createReservation());
        } else {
            reserverView.displayEmptyTextInputToast();
        }
    }

    @Override
    public void validateData(Reservation reservation) {
        ValidationEnums validation = reserverModel.checkReservation(reservation);
        switch (validation) {
            case NULL_DATES:
                reserverView.displayNullParkingSpotToast();
                break;
            case IMPOSSIBLE_DATES:
                reserverView.displayImpossibleDateToast();
                break;
            case INVALID_DATES:
                reserverView.displayInvalidDateToast();
                break;
            case INVALID_PARKING_SPOT:
                reserverView.displayInvalidParkingSpotToast();
                break;
            case ALREADY_RESERVED:
                reserverView.displayAlreadyReservedToast();
                break;
            case RESERVATION_COMPLETED:
                reserverModel.addReservation();
                reserverView.displayReservationCompletedToast();
                returnToMainActivity();
                break;
        }
    }
}
