package com.mobile.tandil.javabaseproject.mvp.contract;

public interface ParkingContract {
    interface Model {
        void setAvailableParkingSpots(int availableParkingSpots);
        int getAvailableParkingSpots();
    }

    interface Presenter {
        void showAvailableParkingSpots();
    }

    interface View {
        void displayAvailableParkingSpots(String availableParkingSpots);
    }
}
