package com.mobile.tandil.javabaseproject.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mobile.tandil.javabaseproject.databinding.FragmentDateBinding;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DateFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.presenter.DateFragmentPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.DateFragmentView;

public class DatePickerFragment extends DialogFragment {
    public static final String DATE_FRAGMENT_TAG = "DATE_FRAGMENT_TAG";
    public static final String DATE_LISTENER_KEY = "DATE_LISTENER_KEY";
    private FragmentDateBinding binding;
    private DateFragmentContract.Presenter datePresenter;
    private ListenerPickerFragment listenerPickerFragment;

    public DatePickerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentDateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        datePresenter = new DateFragmentPresenter(new DateFragmentView(this));
        listenerPickerFragment = (ListenerPickerFragment) getArguments().getSerializable(DATE_LISTENER_KEY);
        setListener();
    }

    public void setListener() {
        binding.fragmentDialogAcceptButton.setOnClickListener(
                view -> datePresenter.onPressAcceptedButton(binding.datePickerDialogFragment, listenerPickerFragment));
        binding.fragmentDialogCancelButton.setOnClickListener(view -> datePresenter.onPressCancelButton());
    }

    public static DatePickerFragment newInstance(ListenerPickerFragment listener) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putSerializable(DATE_LISTENER_KEY, listener);
        fragment.setArguments(args);
        fragment.setCancelable(false);
        return fragment;
    }
}
