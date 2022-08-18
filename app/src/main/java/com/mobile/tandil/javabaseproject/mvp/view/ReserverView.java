package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.StringRes;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.activity.ReserverActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityReserverBinding;
import com.mobile.tandil.javabaseproject.fragment.DatePickerFragment;
import com.mobile.tandil.javabaseproject.fragment.TimePickerFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.ReserverContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

public class ReserverView extends ActivityView implements ReserverContract.View {
    private ActivityReserverBinding binding;

    public ReserverView(Activity activity, ActivityReserverBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void finishReserverActivity() {
        ReserverActivity activity = (ReserverActivity) this.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override
    public void displayDatePicker(ListenerPickerFragment listener) {
        DatePickerFragment fragment = DatePickerFragment.newInstance(listener);
        FragmentManager fragmentManager = getFragmentManager();
        fragment.show(fragmentManager, DatePickerFragment.DATE_FRAGMENT_TAG);
    }

    @Override
    public void displayTimePicker(ListenerPickerFragment listener) {
        TimePickerFragment fragment = TimePickerFragment.newInstance(listener);
        FragmentManager fragmentManager = getFragmentManager();
        fragment.show(fragmentManager, TimePickerFragment.TIME_FRAGMENT_TAG);
    }

    private void displayToast(@StringRes int displayMessage) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, displayMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void displayInvalidDateToast() {
        displayToast(R.string.toast_invalid_dates);
    }

    @Override
    public void displayInvalidParkingSpotToast() {
        displayToast(R.string.toast_invalid_parking_spot);
    }

    @Override
    public void displayAlreadyReservedToast() {
        displayToast(R.string.toast_already_reserved);
    }

    @Override
    public void displayReservationCompletedToast() {
        displayToast(R.string.toast_reservation_done);
    }

    @Override
    public void displayEmptyTextInputToast() {
        displayToast(R.string.toast_empty_text_inputs);
    }

    @Override
    public void displayNullParkingSpotToast() {
        displayToast(R.string.toast_null_dates);
    }
}
