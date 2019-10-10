package com.amlzq.android.viewer.material.tab;


import android.os.Bundle;

import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.material.R;

/**
 * 通知
 */
public class NotificationsFragment extends MyBaseFragment {
    public static final String TAG = "NotificationsFragment";

    public NotificationsFragment() {
        // Required empty public constructor
    }

    public static NotificationsFragment newInstance() {
        return new NotificationsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_notifications;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);
        setTitle(R.string.title_notifications);
    }

}
