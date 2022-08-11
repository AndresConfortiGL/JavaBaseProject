package com.mobile.tandil.javabaseproject.db;

import com.mobile.tandil.javabaseproject.entity.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationDatabase {
    private static ReservationDatabase instance = null;
    private final HashMap<Integer, List<Reservation>> reservations = new HashMap<>();
    private Long parkingLots;

    public static ReservationDatabase getInstance() {
        if (instance == null) {
            instance = new ReservationDatabase();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        if (reservations.get(reservation.getParkingNumber()) == null) {
            List<Reservation> reservationsList = new ArrayList<>();
            reservationsList.add(reservation);
            reservations.put(reservation.getParkingNumber(), reservationsList);
        } else {
            reservations.get(reservation.getParkingNumber()).add(reservation);
        }
    }

    public Long getParkingLots() {
        return parkingLots;
    }

    public List<Reservation> getReservations(int parkingLot) {
        return reservations.get(parkingLot);
    }

    public void setParkingLots(Long parkingLots) {
        this.parkingLots = parkingLots;
    }
}
