package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.db.ReservationDatabase;
import com.mobile.tandil.javabaseproject.entity.Reservation;
import com.mobile.tandil.javabaseproject.mvp.contract.ReserverContract;
import com.mobile.tandil.javabaseproject.util.Constants;
import com.mobile.tandil.javabaseproject.util.ValidationEnums;
import java.util.Calendar;
import java.util.List;

public class ReserverModel implements ReserverContract.Model {
    private boolean isCheckIn;
    private Calendar checkIn;
    private Calendar checkOut;
    private String securityCode;
    private int parkingLot;
    private final ReservationDatabase db;

    public ReserverModel(ReservationDatabase instance) {
        db = instance;
    }

    @Override
    public void saveDateDataFragment(Calendar date) {
        if (isCheckIn) {
            checkIn = date;
        } else {
            checkOut = date;
        }
    }

    @Override
    public void saveTimeDataFragment(Calendar time) {
        if (isCheckIn) {
            checkIn.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
            checkIn.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
        } else {
            checkOut.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
            checkOut.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
        }
    }

    @Override
    public void isCheckIn(boolean isCheckIn) {
        this.isCheckIn = isCheckIn;
    }

    @Override
    public void setParkingData(int parkingLot, String securityCode) {
        this.parkingLot = parkingLot;
        this.securityCode = securityCode;
    }

    @Override
    public Reservation createReservation() {
        return new Reservation(checkIn, checkOut, parkingLot, securityCode);
    }

    @Override
    public void addReservation() {
        db.addReservation(new Reservation(checkIn, checkOut, parkingLot, securityCode));
    }

    @Override
    public ValidationEnums checkReservation(Reservation reservation) {
        if (reservation.getCheckOut() == null || reservation.getCheckIn() == null) {
            return ValidationEnums.NULL_DATES;
        } else if (reservation.getCheckIn().after(reservation.getCheckOut()) || reservation.getCheckIn().compareTo(reservation.getCheckOut()) == 0) {
            return ValidationEnums.INVALID_DATES;
        } else if (reservation.getParkingNumber() > db.getParkingLots() || reservation.getParkingNumber() < Constants.MIN_LIMIT) {
            return ValidationEnums.INVALID_PARKING_SPOT;
        } else if (isAlreadyReserved(reservation.getCheckIn(), reservation.getCheckOut(), reservation.getParkingNumber())) {
            return ValidationEnums.ALREADY_RESERVED;
        } else
            return ValidationEnums.RESERVATION_COMPLETED;
    }

    @Override
    public boolean isAlreadyReserved(Calendar checkIn, Calendar checkOut, int parkingSpot) {
        List<Reservation> reservation = db.getReservations(parkingSpot);
        boolean isReserved = false;

        if (reservation != null) {
            for (int i = 0; i < reservation.size(); i++) {
                if (checkIn.equals(reservation.get(i).getCheckIn()) && checkOut.equals(reservation.get(i).getCheckOut())) {
                    isReserved = true;
                } else if (checkIn.after(reservation.get(i).getCheckIn()) && checkOut.before(reservation.get(i).getCheckOut())) {
                    isReserved = true;
                } else if (checkIn.before(reservation.get(i).getCheckIn()) && checkOut.after(reservation.get(i).getCheckOut())) {
                    isReserved = true;
                } else if (checkIn.after(reservation.get(i).getCheckIn()) && checkOut.after(reservation.get(i).getCheckOut())) {
                    isReserved = true;
                } else if (checkIn.before(reservation.get(i).getCheckIn()) && checkOut.before(reservation.get(i).getCheckOut())) {
                    isReserved = true;
                }
            }
        }
        return isReserved;
    }
}
