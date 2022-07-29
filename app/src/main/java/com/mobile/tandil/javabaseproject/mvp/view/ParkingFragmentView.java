package com.mobile.tandil.javabaseproject.mvp.view;

import android.content.Context;
import android.widget.Toast;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.fragment.ParkingFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView;

public class ParkingFragmentView extends FragmentView implements ParkingFragmentContract.View {

    public ParkingFragmentView(ParkingFragment fragment) {
        super(fragment);
    }

    @Override
    public void displayAvailableParking(Long number, ListenerDialogFragment listener) {
        listener.parkingListener(number);
        dismissFragment();
    }

    @Override
    public void dismissFragment() {
        ParkingFragment fragment = (ParkingFragment) this.getFragment();
        if (fragment != null) {
            fragment.dismiss();
        }
    }

    @Override
    public void displayToastEmptyValue() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.toast_empty_message), Toast.LENGTH_SHORT).show();
        }
    }
}
