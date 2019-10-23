package com.amlzq.android.viewer.material.complex;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.tabpage.DashboardFragment;
import com.amlzq.android.viewer.material.tabpage.HomeFragment;
import com.amlzq.android.viewer.material.tabpage.NotificationsFragment;

import java.io.PrintWriter;

/**
 * android.support.design.widget.BottomNavigationView
 * 实践
 */
public class BottomNavigationFragmentActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "BottomNavigationFragmentActivity";

    HomeFragment mHomeFragment;
    DashboardFragment mDashboardFragment;
    NotificationsFragment mNotificationsFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_fragment);
        setTitle(TAG);

        mFragmentManager = getSupportFragmentManager();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
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

        int id = menuItem.getItemId();
        if (id == R.id.navigation_home) {
            if (mHomeFragment == null) {
                mHomeFragment = HomeFragment.newInstance();
                transaction.add(R.id.fragment_container, mHomeFragment, HomeFragment.TAG);
            } else {
                transaction.show(mHomeFragment);
            }
            transaction.commitAllowingStateLoss();
        } else if (id == R.id.navigation_dashboard) {
            if (mDashboardFragment == null) {
                mDashboardFragment = DashboardFragment.newInstance();
                transaction.add(R.id.fragment_container, mDashboardFragment, DashboardFragment.TAG);
            } else {
                transaction.show(mDashboardFragment);
            }
            transaction.commitAllowingStateLoss();
        } else if (id == R.id.navigation_notifications) {
            if (mNotificationsFragment == null) {
                mNotificationsFragment = NotificationsFragment.newInstance();
                transaction.add(R.id.fragment_container, mNotificationsFragment, NotificationsFragment.TAG);
            } else {
                transaction.show(mNotificationsFragment);
            }
            transaction.commitAllowingStateLoss();
        }

        Log.i("", "dump start");
        mFragmentManager.dump("", null, new PrintWriter(System.out, true), null);
        Log.i("", "dump end");
        return false;
    }

}
