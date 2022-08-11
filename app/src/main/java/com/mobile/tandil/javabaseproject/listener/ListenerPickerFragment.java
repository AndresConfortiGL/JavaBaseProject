package com.mobile.tandil.javabaseproject.listener;

import java.io.Serializable;
import java.util.Calendar;

public interface ListenerPickerFragment extends Serializable {
    void dateFragmentListener(Calendar date);
    void timeFragmentListener(Calendar time);
}
