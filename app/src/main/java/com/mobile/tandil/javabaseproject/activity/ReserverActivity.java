package com.mobile.tandil.javabaseproject.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityReserverBinding;
import com.mobile.tandil.javabaseproject.db.ReservationDatabase;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ReserverContract;
import com.mobile.tandil.javabaseproject.mvp.model.ReserverModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ReserverPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ReserverView;
import java.util.Calendar;

public class ReserverActivity extends AppCompatActivity implements ListenerPickerFragment {
    private ReserverContract.Presenter presenter;
    private ActivityReserverBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReserverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ReserverPresenter(new ReserverView(this, binding), new ReserverModel(ReservationDatabase.getInstance()));
        setListener();
    }

    private void setListener() {
        binding.reserverButtonCheckIn.setOnClickListener(view -> presenter.showCheckInDateFragment(this));
        binding.reserverButtonCheckOut.setOnClickListener(view -> presenter.showCheckOutDateFragment(this));
        binding.reserverButtonContinue.setOnClickListener(view -> presenter.saveParkingData(
                binding.reserverParkingLotTextInput.getText().toString(),
                binding.reserverSecurityCodeTextInput.getText().toString())
        );
        binding.reserverButtonBack.setOnClickListener(view -> presenter.returnToMainActivity());
    }

    @Override
    public void dateFragmentListener(Calendar date) {
        presenter.saveDateListener(date, this);
    }

    @Override
    public void timeFragmentListener(Calendar time) {
        presenter.saveTimeListener(time);
    }

}
