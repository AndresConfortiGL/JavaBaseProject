package com.mobile.tandil.javabaseproject.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mobile.tandil.javabaseproject.databinding.FragmentParkingBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerDialogFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingFragmentPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ParkingFragmentView;

public class ParkingFragment extends DialogFragment {
    public static final String PARKING_FRAGMENT_TAG = "PARKING_FRAGMENT_TAG";
    public static final String PARKING_LISTENER_KEY = "PARKING_LISTENER_KEY";
    private FragmentParkingBinding binding;
    private ParkingFragmentContract.Presenter fragmentPresenter;
    private ListenerDialogFragment listenerDialogFragment;

    public ParkingFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentParkingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentPresenter = new ParkingFragmentPresenter(new ParkingFragmentView(this));
        listenerDialogFragment = (ListenerDialogFragment) getArguments().getSerializable(PARKING_LISTENER_KEY);
        setListener();
    }

    public void setListener() {
        binding.fragmentDialogAcceptButton.setOnClickListener(
                view -> fragmentPresenter.onPressAcceptedButton(
                        binding.fragmentDialogSetAvailableNumber.getText().toString(), listenerDialogFragment));
        binding.fragmentDialogCancelButton.setOnClickListener(view -> fragmentPresenter.onPressCancelButton());
    }

    public static ParkingFragment newInstance(ListenerDialogFragment listener) {
        ParkingFragment fragment = new ParkingFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARKING_LISTENER_KEY, listener);
        fragment.setArguments(args);
        fragment.setCancelable(false);
        return fragment;
    }
}
