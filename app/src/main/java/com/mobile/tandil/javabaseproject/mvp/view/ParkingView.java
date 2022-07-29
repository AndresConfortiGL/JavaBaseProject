package com.mobile.tandil.javabaseproject.mvp.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.fragment.ParkingFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.View {

    private ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @SuppressLint("StringFormatMatches")
    @Override
    public void displayAvailableParkingSpots(Long parkingSpots) {
        binding.parkingTextView.setText(getActivity().getString(R.string.activity_main_available_text, parkingSpots));
    }

    @Override
    public void displayFragment(ListenerDialogFragment listener) {
        ParkingFragment fragment = ParkingFragment.newInstance(listener);
        FragmentManager fragmentManager = getFragmentManager();
        fragment.show(fragmentManager, ParkingFragment.PARKING_FRAGMENT_TAG);
    }
}
