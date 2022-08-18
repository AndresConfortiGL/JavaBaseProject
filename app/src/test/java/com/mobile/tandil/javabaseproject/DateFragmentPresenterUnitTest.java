package com.mobile.tandil.javabaseproject;

import android.widget.DatePicker;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DateFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.DateFragmentPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.DateFragmentView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateFragmentPresenterUnitTest {
    private DateFragmentContract.Presenter presenter;
    private static final DatePicker NULL_DATE = null;

    @Mock
    private DatePicker validDate;
    @Mock
    private DateFragmentView view;
    @Mock
    private ListenerPickerFragment listener;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        presenter = new DateFragmentPresenter(view);
    }

    @Test
    public void TestOnPressAcceptedButtonNullDate() {
        presenter.onPressAcceptedButton(NULL_DATE, listener);

        Mockito.verify(view).displayToastEmptyValue();
    }

    @Test
    public void TestOnPressAcceptedButtonValidDate() {
        presenter.onPressAcceptedButton(validDate, listener);

        Mockito.verify(view).saveDatePicker(validDate, listener);
    }

    @Test
    public void TestOnPressCancelButton() {
        presenter.onPressCancelButton();

        Mockito.verify(view).dismissFragment();
    }
}
