package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ParkingView extends ActivityView implements ParkingContract.View {

    private ActivityMainBinding binding;

    public ParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void displayAvailableParkingSpots(String parkingSpots){
        binding.parkingTextView.setText(getActivity().getString(R.string.activity_main_available_text) + parkingSpots);
    }
}
