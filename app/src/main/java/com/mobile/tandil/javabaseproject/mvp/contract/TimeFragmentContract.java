package com.mobile.tandil.javabaseproject.mvp.contract;

import android.widget.TimePicker;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;

public interface TimeFragmentContract {

    interface Presenter {
        void onPressAcceptedButton(TimePicker time, ListenerPickerFragment listener);
        void onPressCancelButton();
    }

    interface View {
        void dismissFragment();
        void displayToastEmptyValue();
        void saveTimePicker(TimePicker time, ListenerPickerFragment listener);
    }
}
