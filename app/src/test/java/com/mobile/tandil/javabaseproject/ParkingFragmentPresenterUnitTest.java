package com.mobile.tandil.javabaseproject;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingFragmentPresenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingFragmentPresenterUnitTest {
    private static final String EMPTY_STRING = "";
    private static final String VALID_STRING = "10";
    private ParkingFragmentContract.Presenter presenter;

    @Mock
    private ListenerDialogFragment listener;

    @Mock
    private ParkingFragmentContract.View view;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        presenter = new ParkingFragmentPresenter(view);
    }

    @Test
    public void testOnPressAcceptedButtonEmptyString() {
        presenter.onPressAcceptedButton(EMPTY_STRING, listener);

        Mockito.verify(view).displayToastEmptyValue();
    }

    @Test
    public void testOnPressAcceptedButtonValidString() {
        presenter.onPressAcceptedButton(VALID_STRING, listener);

        Mockito.verify(view).displayAvailableParking(Long.valueOf(VALID_STRING), listener);
    }

    @Test
    public void testOnPressCancelButton() {
        presenter.onPressCancelButton();

        Mockito.verify(view).dismissFragment();
    }
}
