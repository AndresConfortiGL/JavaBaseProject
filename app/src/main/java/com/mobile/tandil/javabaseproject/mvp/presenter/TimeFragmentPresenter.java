package com.mobile.tandil.javabaseproject.mvp.presenter;

import android.widget.TimePicker;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.TimeFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.view.TimeFragmentView;

public class TimeFragmentPresenter implements TimeFragmentContract.Presenter {
    private final TimeFragmentContract.View timeFragmentView;

    public TimeFragmentPresenter(TimeFragmentView timeFragmentView) {
        this.timeFragmentView = timeFragmentView;
    }

    @Override
    public void onPressAcceptedButton(TimePicker time, ListenerPickerFragment listener) {
        if (time != null) {
            timeFragmentView.saveTimePicker(time, listener);
        } else {
            timeFragmentView.displayToastEmptyValue();
        }
    }

    @Override
    public void onPressCancelButton() {
        timeFragmentView.dismissFragment();
    }
}
