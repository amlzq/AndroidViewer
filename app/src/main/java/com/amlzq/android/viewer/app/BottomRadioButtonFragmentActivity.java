package com.amlzq.android.viewer.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.util.FragmentUtil;
import com.amlzq.android.viewer.MyBaseAppCompatActivity;
import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.material.tab.DashboardFragment;
import com.amlzq.android.viewer.material.tab.HomeFragment;
import com.amlzq.android.viewer.material.tab.NotificationsFragment;

/**
 * RadioButton+Fragment
 */
public class BottomRadioButtonFragmentActivity extends MyBaseAppCompatActivity {

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
        bottomNavigationView.setOnCheckedChangeListener(mCheckedChangeListener);

        // 默认选中
//        bottomNavigationView.check(R.id.navigation_home);
//        mCheckedChangeListener.onCheckedChanged(bottomNavigationView, R.id.navigation_home);
    }

    private RadioGroup.OnCheckedChangeListener mCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            switch (checkedId) {
                case R.id.navigation_home:
                    if (mHomeFragment == null) {
                        mHomeFragment = HomeFragment.newInstance();
                    }
                    transaction.replace(R.id.fragment_container, mHomeFragment, HomeFragment.TAG);
                    mHomeFragment.setTransactionOpCmd(FragmentLauncher.FLAG_REPLACE);
                    mTargetFragment = mHomeFragment;
                    break;
                case R.id.navigation_dashboard:
                    if (mDashboardFragment == null) {
                        mDashboardFragment = DashboardFragment.newInstance();
                    }
                    transaction.replace(R.id.fragment_container, mDashboardFragment, DashboardFragment.TAG);
                    mDashboardFragment.setTransactionOpCmd(FragmentLauncher.FLAG_REPLACE);
                    mTargetFragment = mDashboardFragment;
                    break;
                case R.id.navigation_notifications:
                    if (mNotificationsFragment == null) {
                        mNotificationsFragment = NotificationsFragment.newInstance();
                    }
                    transaction.replace(R.id.fragment_container, mNotificationsFragment, NotificationsFragment.TAG);
                    mNotificationsFragment.setTransactionOpCmd(FragmentLauncher.FLAG_REPLACE);
                    mTargetFragment = mNotificationsFragment;
                    break;
            }
            FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
        }
    };

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

}
