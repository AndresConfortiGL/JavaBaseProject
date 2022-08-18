package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.entity.Reservation;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.util.ValidationEnums;
import java.util.Calendar;

public interface ReserverContract {

    interface Presenter {
        void returnToMainActivity();
        void showCheckInDateFragment(ListenerPickerFragment listener);
        void showCheckOutDateFragment(ListenerPickerFragment listener);
        void saveDateListener(Calendar date, ListenerPickerFragment listener);
        void saveTimeListener(Calendar time);
        void saveParkingData(String parkingLot, String securityCode);
    }

    interface View {
        void finishReserverActivity();
        void displayDatePicker(ListenerPickerFragment listener);
        void displayTimePicker(ListenerPickerFragment listener);
        void displayInvalidDateToast();
        void displayInvalidParkingSpotToast();
        void displayAlreadyReservedToast();
        void displayReservationCompletedToast();
        void displayEmptyTextInputToast();
        void displayNullParkingSpotToast();
    }

    interface Model {
        void saveDateDataFragment(Calendar date);
        void saveTimeDataFragment(Calendar time);
        void isCheckIn(boolean isCheckIn);
        void setParkingData(int parkingLot, String securityCode);
        void addReservation();
        boolean isAlreadyReserved(Calendar checkIn, Calendar checkOut, int parkingSpot);
        Reservation createReservation();
        ValidationEnums checkReservation(Reservation reservation);
    }
}
