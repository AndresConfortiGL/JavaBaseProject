package com.mobile.tandil.javabaseproject.mvp.view.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

public class ActivityView {
    private final WeakReference<Activity> activityRef;

    public ActivityView(Activity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public Activity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        return (activity != null) ? activity.getFragmentManager() : null;
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }
}
