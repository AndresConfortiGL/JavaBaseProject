package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingFragmentContract;

public class ParkingFragmentPresenter implements ParkingFragmentContract.Presenter {

    private final ParkingFragmentContract.View view;

    public ParkingFragmentPresenter(ParkingFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void onPressAcceptedButton(String number, ListenerDialogFragment listener) {
        if (!number.isEmpty()) {
            view.displayAvailableParking(Long.valueOf(number), listener);
        } else {
            view.displayToastEmptyValue();
        }
    }

    @Override
    public void onPressCancelButton() {
        view.dismissFragment();
    }
}
