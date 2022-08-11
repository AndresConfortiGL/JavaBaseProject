package com.mobile.tandil.javabaseproject.mvp.contract;

import android.widget.DatePicker;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;

public interface DateFragmentContract {

    interface Presenter {
        void onPressAcceptedButton(DatePicker date, ListenerPickerFragment listener);
        void onPressCancelButton();
    }

    interface View {
        void dismissFragment();
        void displayToastEmptyValue();
        void saveDatePicker(DatePicker date, ListenerPickerFragment listener);
    }
}
