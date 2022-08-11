package com.mobile.tandil.javabaseproject.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mobile.tandil.javabaseproject.databinding.FragmentTimeBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.TimeFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.TimeFragmentPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.TimeFragmentView;

public class TimePickerFragment extends DialogFragment {
    public static final String TIME_FRAGMENT_TAG = "TIME_FRAGMENT_TAG";
    public static final String TIME_LISTENER_KEY = "TIME_LISTENER_KEY";
    private FragmentTimeBinding binding;
    private TimeFragmentContract.Presenter timePresenter;
    private ListenerPickerFragment listenerTimeFragment;

    public TimePickerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentTimeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timePresenter = new TimeFragmentPresenter(new TimeFragmentView(this));
        listenerTimeFragment = (ListenerPickerFragment) getArguments().getSerializable(TIME_LISTENER_KEY);
        setListener();
    }

    public void setListener() {
        binding.fragmentDialogAcceptButton.setOnClickListener(view -> timePresenter.onPressAcceptedButton(binding.timePickerDialogFragment, listenerTimeFragment));
        binding.fragmentDialogCancelButton.setOnClickListener(view -> timePresenter.onPressCancelButton());
    }

    public static TimePickerFragment newInstance(ListenerPickerFragment listener) {
        TimePickerFragment fragment = new TimePickerFragment();
        Bundle args = new Bundle();
        args.putSerializable(TIME_LISTENER_KEY, listener);
        fragment.setArguments(args);
        fragment.setCancelable(false);
        return fragment;
    }
}
