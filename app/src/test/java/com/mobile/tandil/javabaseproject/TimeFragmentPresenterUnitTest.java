package com.mobile.tandil.javabaseproject;

import android.widget.TimePicker;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.TimeFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.TimeFragmentPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.TimeFragmentView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TimeFragmentPresenterUnitTest {
    private TimeFragmentContract.Presenter presenter;
    private static final TimePicker NULL_TIME = null;

    @Mock
    private TimePicker validTime;

    @Mock
    private TimeFragmentView view;
    @Mock
    private ListenerPickerFragment listener;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        presenter = new TimeFragmentPresenter(view);
    }

    @Test
    public void TestOnPressAcceptedButtonNullDate() {
        presenter.onPressAcceptedButton(NULL_TIME, listener);

        Mockito.verify(view).displayToastEmptyValue();
    }

    @Test
    public void TestOnPressAcceptedButtonValidDate() {
        presenter.onPressAcceptedButton(validTime, listener);

        Mockito.verify(view).saveTimePicker(validTime, listener);
    }

    @Test
    public void TestOnPressCancelButton() {
        presenter.onPressCancelButton();

        Mockito.verify(view).dismissFragment();
    }
}
