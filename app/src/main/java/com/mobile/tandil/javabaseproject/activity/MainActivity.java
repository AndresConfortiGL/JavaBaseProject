package com.mobile.tandil.javabaseproject.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ParkingView;

public class MainActivity extends AppCompatActivity implements ListenerDialogFragment {

    private ActivityMainBinding binding;
    private ParkingContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ParkingPresenter(new ParkingModel(), new ParkingView(this, binding));
        setListener();
    }

    public void setListener() {
        binding.parkingButton.setOnClickListener(view -> presenter.showFragment(this));
    }

    @Override
    public void parkingListener(Long number) {
        presenter.showAvailableParkingSpots(number);
    }
}
