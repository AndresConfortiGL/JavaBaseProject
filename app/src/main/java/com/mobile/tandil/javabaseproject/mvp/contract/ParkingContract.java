package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;

public interface ParkingContract {

    interface Presenter {
        void showFragment(ListenerDialogFragment listener);
        void showAvailableParkingSpots(Long value);
        void showReserverActivity();
    }

    interface View {
        void displayFragment(ListenerDialogFragment listener);
        void displayAvailableParkingSpots(Long availableParkingSpots);
        void displayReserverActivity();
        void displayToastNoSpace();
    }

    interface Model {
        void setAvailableParkingSpots(Long availableParkingSpots);
        long getAvailableParkingSpots();
    }
}
