package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.activity.ReserverActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.fragment.ParkingFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;
import java.util.Objects;

public class ParkingView extends ActivityView implements ParkingContract.View {
    private ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void displayAvailableParkingSpots(Long parkingSpots) {
        binding.parkingAvailableText.setText(String.format(String.valueOf(parkingSpots)));
        binding.parkingAvailableText.setVisibility(View.VISIBLE);
        binding.reserveParkingButton.setClickable(true);
    }

    @Override
    public void displayFragment(ListenerDialogFragment listener) {
        ParkingFragment fragment = ParkingFragment.newInstance(listener);
        FragmentManager fragmentManager = getFragmentManager();
        fragment.show(fragmentManager, ParkingFragment.PARKING_FRAGMENT_TAG);
    }

    @Override
    public void displayReserverActivity() {
        Intent i = new Intent(getContext(), ReserverActivity.class);
        Objects.requireNonNull(getActivity()).startActivity(i);
    }

    @Override
    public void displayToastNoSpace() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.toast_no_space_message), Toast.LENGTH_SHORT).show();
        }
    }
}
