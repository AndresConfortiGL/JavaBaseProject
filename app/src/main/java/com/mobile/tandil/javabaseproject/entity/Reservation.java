package com.mobile.tandil.javabaseproject.entity;

import java.util.Calendar;

public class Reservation {
    private final Calendar checkIn;
    private final Calendar checkOut;
    private final int parkingLot;
    private final String securityCode;

    public Reservation(Calendar checkIn, Calendar checkOut, int parkingLot, String securityCode) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.securityCode = securityCode;
        this.parkingLot = parkingLot;
    }

    public Calendar getCheckIn() {
        return checkIn;
    }

    public Calendar getCheckOut() {
        return checkOut;
    }

    public int getParkingNumber() {
        return parkingLot;
    }

    public String getSecurityCode() {
        return securityCode;
    }
}
