package com.mobile.tandil.javabaseproject.mvp.presenter;

import android.widget.DatePicker;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DateFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.view.DateFragmentView;

public class DateFragmentPresenter implements DateFragmentContract.Presenter {
    private final DateFragmentContract.View dateFragmentView;

    public DateFragmentPresenter(DateFragmentView dateFragmentView) {
        this.dateFragmentView = dateFragmentView;
    }

    @Override
    public void onPressAcceptedButton(DatePicker date, ListenerPickerFragment listener) {
        if (date != null) {
            dateFragmentView.saveDatePicker(date, listener);
        } else {
            dateFragmentView.displayToastEmptyValue();
        }
    }

    @Override
    public void onPressCancelButton() {
        dateFragmentView.dismissFragment();
    }
}
