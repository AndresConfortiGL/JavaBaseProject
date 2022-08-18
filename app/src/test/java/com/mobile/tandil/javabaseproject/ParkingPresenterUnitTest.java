package com.mobile.tandil.javabaseproject;

import com.mobile.tandil.javabaseproject.db.ReservationDatabase;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingPresenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingPresenterUnitTest {
    private static final long VALID_VALUE = 10;
    private static final long INVALID_VALUE = -1;
    private ParkingContract.Presenter presenter;

    @Mock
    private ListenerDialogFragment listener;

    @Mock
    private ParkingContract.View view;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        presenter = new ParkingPresenter(new ParkingModel(ReservationDatabase.getInstance()), view);
    }

    @Test
    public void testShowFragmentListener() {
        presenter.showFragment(listener);

        Mockito.verify(view).displayFragment(listener);
    }

    @Test
    public void testShowAvailableParkingSpotsInvalidValue() {
        presenter.showAvailableParkingSpots(INVALID_VALUE);

        Mockito.verify(view).displayAvailableParkingSpots(INVALID_VALUE);
    }

    @Test
    public void testShowAvailableParkingSpotsValidValue() {
        presenter.showAvailableParkingSpots(VALID_VALUE);

        Mockito.verify(view).displayAvailableParkingSpots(VALID_VALUE);
    }

    @Test
    public void testShowReserverActivityValidValue() {
        presenter.showAvailableParkingSpots(VALID_VALUE);

        presenter.showReserverActivity();

        Mockito.verify(view).displayReserverActivity();
    }

    @Test
    public void testShowReserverActivityInvalidValue() {
        presenter.showAvailableParkingSpots(INVALID_VALUE);

        presenter.showReserverActivity();

        Mockito.verify(view).displayToastNoSpace();
    }
}
