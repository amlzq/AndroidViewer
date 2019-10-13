package com.amlzq.android.viewer.material.complex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.amlzq.android.ApplicationConstant;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.util.FragmentUtil;
import com.amlzq.android.viewer.MyBaseAppCompatActivity;
import com.amlzq.android.viewer.material.ActionAppCompatActivity;
import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.WebAppCompatActivity;
import com.amlzq.android.viewer.material.tab.DashboardFragment;
import com.amlzq.android.viewer.material.tab.HomeFragment;
import com.amlzq.android.viewer.material.tab.NotificationsFragment;

import java.io.PrintWriter;

/**
 * android.support.design.widget.BottomNavigationView
 * 实践
 */
public class BottomNavigationFragmentActivity extends MyBaseAppCompatActivity {
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
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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

            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                    transaction.add(R.id.fragment_container, mHomeFragment, HomeFragment.TAG);
                } else {
                    transaction.show(mHomeFragment);
                }
                mHomeFragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
                FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
            } else if (id == R.id.navigation_dashboard) {
                if (mDashboardFragment == null) {
                    mDashboardFragment = DashboardFragment.newInstance();
                    transaction.add(R.id.fragment_container, mDashboardFragment, DashboardFragment.TAG);
                } else {
                    transaction.show(mDashboardFragment);
                }
                mDashboardFragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
                FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
            } else if (id == R.id.navigation_notifications) {
                if (mNotificationsFragment == null) {
                    mNotificationsFragment = NotificationsFragment.newInstance();
                    transaction.add(R.id.fragment_container, mNotificationsFragment, NotificationsFragment.TAG);
                } else {
                    transaction.show(mNotificationsFragment);
                }
                mNotificationsFragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
                FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
            }

            Log.i("dump start");
            mFragmentManager.dump("", null, new PrintWriter(System.out, true), null);
            Log.i("dump end");
            return false;
        }
    };

    @Override
    public void onFragmentInteraction(Bundle bundle) {
        String tag = bundle.getString(ApplicationConstant.TARGET_VIEW);
        Log.d(tag);

        if (ActionAppCompatActivity.TAG.equals(tag)) {
            Intent intent = new Intent(mContext, ActionAppCompatActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (WebAppCompatActivity.TAG.equals(tag)) {
            Intent intent = new Intent(mContext, WebAppCompatActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(requestCode + "," + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        mTargetFragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        // 检查当前Fragment内部是否有待处理的回退逻辑
        if (mTargetFragment != null && mTargetFragment.onBackPressed()) {
            // 已消费
        } else {
            super.onBackPressed(); // finish this activity
        }
    }

}
