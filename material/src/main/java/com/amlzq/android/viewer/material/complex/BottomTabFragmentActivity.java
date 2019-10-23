package com.amlzq.android.viewer.material.complex;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.tabpage.DashboardFragment;
import com.amlzq.android.viewer.material.tabpage.HomeFragment;
import com.amlzq.android.viewer.material.tabpage.NotificationsFragment;

import java.io.PrintWriter;

/**
 * TabLayout
 * 底部导航
 */
public class BottomTabFragmentActivity extends AppCompatActivity
        implements TabLayout.OnTabSelectedListener {

    public static final String TAG = "BottomTabFragmentActivity";

    HomeFragment mHomeFragment;
    DashboardFragment mDashboardFragment;
    NotificationsFragment mNotificationsFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_fragment);
        setTitle(TAG);

        mFragmentManager = getSupportFragmentManager();
        TabLayout navigation = (TabLayout) findViewById(R.id.navigation);
        navigation.addOnTabSelectedListener(this);
    }

    public boolean onNavigationItemSelected(int position) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mDashboardFragment != null) {
            transaction.hide(mDashboardFragment);
        }
        if (mNotificationsFragment != null) {
            transaction.hide(mNotificationsFragment);
        }
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                    transaction.add(R.id.fragment_container, mHomeFragment, HomeFragment.TAG);
                } else {
                    transaction.show(mHomeFragment);
                }
                transaction.commitAllowingStateLoss();
                return true;
            case 1:
                if (mDashboardFragment == null) {
                    mDashboardFragment = DashboardFragment.newInstance();
                    transaction.add(R.id.fragment_container, mDashboardFragment, DashboardFragment.TAG);
                } else {
                    transaction.show(mDashboardFragment);
                }
                transaction.commitAllowingStateLoss();
                return true;
            case 2:
                if (mNotificationsFragment == null) {
                    mNotificationsFragment = NotificationsFragment.newInstance();
                    transaction.add(R.id.fragment_container, mNotificationsFragment, NotificationsFragment.TAG);
                } else {
                    transaction.show(mNotificationsFragment);
                }
                transaction.commitAllowingStateLoss();
                return true;
        }
        Log.i("", "dump start");
        mFragmentManager.dump("", null, new PrintWriter(System.out, true), null);
        Log.i("", "dump end");
        return false;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        onNavigationItemSelected(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
