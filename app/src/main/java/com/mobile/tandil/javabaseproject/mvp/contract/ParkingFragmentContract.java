package com.mobile.tandil.javabaseproject.mvp.contract;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;

public interface ParkingFragmentContract {

    interface Presenter {
        void onPressAcceptedButton(String number, ListenerDialogFragment listener);
        void onPressCancelButton();
    }

    interface View {
        void displayAvailableParking(Long number, ListenerDialogFragment listener);
        void dismissFragment();
        void displayToastEmptyValue();
    }
}
