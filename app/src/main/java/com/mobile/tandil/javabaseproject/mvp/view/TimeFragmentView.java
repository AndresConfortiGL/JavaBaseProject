package com.mobile.tandil.javabaseproject.mvp.view;

import android.content.Context;
import android.widget.TimePicker;
import android.widget.Toast;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.fragment.TimePickerFragment;
import com.mobile.tandil.javabaseproject.listener.ListenerPickerFragment;
import com.mobile.tandil.javabaseproject.mvp.contract.TimeFragmentContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeFragmentView extends FragmentView implements TimeFragmentContract.View {

    public TimeFragmentView(TimePickerFragment fragment) {
        super(fragment);
    }

    @Override
    public void dismissFragment() {
        TimePickerFragment fragment = (TimePickerFragment) this.getFragment();
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
    public void saveTimePicker(TimePicker time, ListenerPickerFragment listener) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, time.getHour());
        calendar.set(Calendar.MINUTE, time.getMinute());
        listener.timeFragmentListener(calendar);
        dismissFragment();
    }
}
