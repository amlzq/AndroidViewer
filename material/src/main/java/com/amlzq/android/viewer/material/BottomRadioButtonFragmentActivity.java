package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.amlzq.android.viewer.material.complex.DashboardFragment;
import com.amlzq.android.viewer.material.complex.HomeFragment;
import com.amlzq.android.viewer.material.complex.NotificationsFragment;

/**
 * RadioButton+Fragment
 */
public class BottomRadioButtonFragmentActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {

    HomeFragment mHomeFragment;
    DashboardFragment mDashboardFragment;
    NotificationsFragment mNotificationsFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_radio_button_fragment);

        mFragmentManager = getSupportFragmentManager();
        RadioGroup bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnCheckedChangeListener(this);

        // 默认选中
//        bottomNavigationView.check(R.id.navigation_home);
//        mCheckedChangeListener.onCheckedChanged(bottomNavigationView, R.id.navigation_home);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (checkedId == R.id.navigation_home) {
            if (mHomeFragment == null) {
                mHomeFragment = HomeFragment.newInstance();
            }
            transaction.replace(R.id.fragment_container, mHomeFragment, HomeFragment.TAG);
        } else if (checkedId == R.id.navigation_dashboard) {
            if (mDashboardFragment == null) {
                mDashboardFragment = DashboardFragment.newInstance();
            }
            transaction.replace(R.id.fragment_container, mDashboardFragment, DashboardFragment.TAG);
        } else if (checkedId == R.id.navigation_notifications) {
            if (mNotificationsFragment == null) {
                mNotificationsFragment = NotificationsFragment.newInstance();
            }
            transaction.replace(R.id.fragment_container, mNotificationsFragment, NotificationsFragment.TAG);
        }
        transaction.commitAllowingStateLoss();
    }

}
