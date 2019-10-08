package com.amlzq.android.viewer.material.combineduse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.amlzq.android.ApplicationConstant;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.util.FragmentUtil;
import com.amlzq.android.viewer.MyBaseAppCompatActivity;
import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.material.ActionAppCompatActivity;
import com.amlzq.android.viewer.material.WebAppCompatActivity;
import com.amlzq.android.viewer.material.tab.DashboardFragment;
import com.amlzq.android.viewer.material.tab.HomeFragment;
import com.amlzq.android.viewer.material.tab.NotificationsFragment;

import java.io.PrintWriter;

/**
 * TabLayout
 * 底部导航
 */
public class BottomTabFragmentActivity extends MyBaseAppCompatActivity {
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
        navigation.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        });
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
                mHomeFragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
                FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
                return true;
            case 1:
                if (mDashboardFragment == null) {
                    mDashboardFragment = DashboardFragment.newInstance();
                    transaction.add(R.id.fragment_container, mDashboardFragment, DashboardFragment.TAG);
                } else {
                    transaction.show(mDashboardFragment);
                }
                mDashboardFragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
                FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
                return true;
            case 2:
                if (mNotificationsFragment == null) {
                    mNotificationsFragment = NotificationsFragment.newInstance();
                    transaction.add(R.id.fragment_container, mNotificationsFragment, NotificationsFragment.TAG);
                } else {
                    transaction.show(mNotificationsFragment);
                }
                mNotificationsFragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
                FragmentUtil.commitCompat(mFragmentManager, transaction, true, false, true);
                return true;
        }
        Log.i("dump start");
        mFragmentManager.dump("", null, new PrintWriter(System.out, true), null);
        Log.i("dump end");
        return false;
    }

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
