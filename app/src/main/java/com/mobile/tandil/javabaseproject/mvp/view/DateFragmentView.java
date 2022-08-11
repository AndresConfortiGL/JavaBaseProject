package com.mobile.tandil.javabaseproject.mvp.view;

import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.fragment.DatePickerFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.DateFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateFragmentView extends FragmentView implements DateFragmentContract.View {

    public DateFragmentView(DatePickerFragment fragment) {
        super(fragment);
    }

    @Override
    public void dismissFragment() {
        DatePickerFragment fragment = (DatePickerFragment) this.getFragment();
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

    @Override
    public void saveDatePicker(DatePicker date, ListenerPickerFragment listener) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(date.getYear(), date.getMonth(), date.getDayOfMonth());
        listener.dateFragmentListener(calendar);
        dismissFragment();
    }
}
