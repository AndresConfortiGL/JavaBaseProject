package com.mobile.tandil.javabaseproject;

import com.mobile.tandil.javabaseproject.db.ReservationDatabase;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ReserverContract;
import com.mobile.tandil.javabaseproject.mvp.model.ReserverModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ReserverPresenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Calendar;

@RunWith(MockitoJUnitRunner.class)
public class ReserverPresenterUnitTest {

    private static final String EMPTY_STRING = "";
    private static final String VALID_STRING_PARKING_LOT = "5";
    private static final String INVALID_STRING_PARKING_LOT = "20";
    private static final long TOTAL_PARKING_LOTS = 10;
    private static final String VALID_STRING_SECURITY_CODE = "123";
    private ReserverPresenter presenter;
    private ReservationDatabase db;

    @Mock
    private Calendar time;

    @Mock
    private Calendar date;

    @Mock
    private ListenerPickerFragment listener;

    @Mock
    private ReserverContract.View view;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        db = ReservationDatabase.getInstance();
        db.setParkingLots(TOTAL_PARKING_LOTS);
        presenter = new ReserverPresenter(view, new ReserverModel(ReservationDatabase.getInstance()));
    }

    @After
    public void cleanDataBase() {
        db.clearDatabase();
    }

    @Test
    public void testReturnToMainActivity() {
        presenter.returnToMainActivity();

        Mockito.verify(view).finishReserverActivity();
    }

    @Test
    public void testShowCheckInDateFragment() {
        presenter.showCheckInDateFragment(listener);

        Mockito.verify(view).displayDatePicker(listener);
    }

    @Test
    public void testShowCheckOutDateFragment() {
        presenter.showCheckInDateFragment(listener);

        Mockito.verify(view).displayTimePicker(listener);
    }

    @Test
    public void testSaveTimeListener() {
        presenter.saveTimeListener(time);
    }

    @Test
    public void testSaveDateListener() {
        presenter.saveDateListener(date, listener);
    }

    @Test
    public void testEmptySaveParkingData() {
        presenter.saveParkingData(EMPTY_STRING, EMPTY_STRING);

        Mockito.verify(view).displayEmptyTextInputToast();
    }

    @Test
    public void testGoodSaveParkingData() {
        presenter.saveParkingData(VALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);
    }

    @Test
    public void testValidateDataNull() {
        presenter.saveParkingData(VALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);

        Mockito.verify(view).displayNullParkingSpotToast();
    }

    @Test
    public void testValidateDataInvalidDate() {
        presenter.showCheckInDateFragment(listener);
        Calendar dateCheckIn = Calendar.getInstance();
        Calendar timeCheckIn = Calendar.getInstance();
        presenter.saveDateListener(dateCheckIn, listener);
        presenter.saveTimeListener(timeCheckIn);
        presenter.showCheckOutDateFragment(listener);
        Calendar dateCheckOut = Calendar.getInstance();
        Calendar timeCheckOut = Calendar.getInstance();
        presenter.saveDateListener(dateCheckOut, listener);
        presenter.saveTimeListener(timeCheckOut);

        presenter.saveParkingData(VALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);

        Mockito.verify(view).displayInvalidDateToast();
    }

    @Test
    public void testValidateDataInvalidParkingSpot() {
        presenter.showCheckInDateFragment(listener);
        Calendar dateCheckIn = Calendar.getInstance();
        dateCheckIn.set(Calendar.DAY_OF_MONTH, 10);
        Calendar timeCheckIn = Calendar.getInstance();
        presenter.saveDateListener(dateCheckIn, listener);
        presenter.saveTimeListener(timeCheckIn);
        presenter.showCheckOutDateFragment(listener);
        Calendar dateCheckOut = Calendar.getInstance();
        Calendar timeCheckOut = dateCheckOut;
        dateCheckOut.set(Calendar.DAY_OF_MONTH, 12);
        presenter.saveDateListener(dateCheckOut, listener);
        presenter.saveTimeListener(timeCheckOut);

        presenter.saveParkingData(INVALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);

        Mockito.verify(view).displayInvalidParkingSpotToast();
    }

    @Test
    public void testValidateDataAlreadyReserved() {
        presenter.showCheckInDateFragment(listener);
        Calendar dateCheckIn = Calendar.getInstance();
        dateCheckIn.set(Calendar.DAY_OF_MONTH, 10);
        Calendar timeCheckIn = Calendar.getInstance();
        presenter.saveDateListener(dateCheckIn, listener);
        presenter.saveTimeListener(timeCheckIn);
        presenter.showCheckOutDateFragment(listener);
        Calendar dateCheckOut = Calendar.getInstance();
        dateCheckOut.set(Calendar.DAY_OF_MONTH, 12);
        Calendar timeCheckOut = Calendar.getInstance();
        presenter.saveDateListener(dateCheckOut, listener);
        presenter.saveTimeListener(timeCheckOut);
        presenter.saveParkingData(VALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);
        presenter.showCheckInDateFragment(listener);
        Calendar dateCheckInNew = Calendar.getInstance();
        dateCheckInNew.set(Calendar.DAY_OF_MONTH, 9);
        Calendar timeCheckInNew = Calendar.getInstance();
        presenter.saveDateListener(dateCheckInNew, listener);
        presenter.saveTimeListener(timeCheckInNew);
        presenter.showCheckOutDateFragment(listener);
        Calendar dateCheckOutNew = Calendar.getInstance();
        dateCheckOutNew.set(Calendar.DAY_OF_MONTH, 13);
        Calendar timeCheckOutNew = Calendar.getInstance();
        presenter.saveDateListener(dateCheckOutNew, listener);
        presenter.saveTimeListener(timeCheckOutNew);

        presenter.saveParkingData(VALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);

        Mockito.verify(view).displayReservationCompletedToast();
        Mockito.verify(view).displayAlreadyReservedToast();
    }

    @Test
    public void testValidateDataCompleted() {
        presenter.showCheckInDateFragment(listener);
        Calendar dateCheckIn = Calendar.getInstance();
        dateCheckIn.set(Calendar.DAY_OF_MONTH, 10);
        Calendar timeCheckIn = Calendar.getInstance();
        timeCheckIn.set(Calendar.HOUR_OF_DAY, 4);
        timeCheckIn.set(Calendar.MINUTE, 20);
        presenter.saveDateListener(dateCheckIn, listener);
        presenter.saveTimeListener(timeCheckIn);
        presenter.showCheckOutDateFragment(listener);
        Calendar dateCheckOut = Calendar.getInstance();
        dateCheckOut.set(Calendar.DAY_OF_MONTH, 12);
        Calendar timeCheckOut = Calendar.getInstance();
        timeCheckOut.set(Calendar.HOUR_OF_DAY, 5);
        timeCheckOut.set(Calendar.MINUTE, 30);
        presenter.saveDateListener(dateCheckOut, listener);
        presenter.saveTimeListener(timeCheckOut);

        presenter.saveParkingData(VALID_STRING_PARKING_LOT, VALID_STRING_SECURITY_CODE);

        Mockito.verify(view).displayReservationCompletedToast();
    }

}
