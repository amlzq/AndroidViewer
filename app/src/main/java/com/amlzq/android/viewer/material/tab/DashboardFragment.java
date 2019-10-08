package com.amlzq.android.viewer.material.tab;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.app.SimpleFragmentPagerAdapter;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.viewer.MyBaseContainerFragment;
import com.amlzq.android.viewer.R;

/**
 * 仪表板
 */
public class DashboardFragment extends MyBaseContainerFragment {
    public static final String TAG = "DashboardFragment";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SimpleFragmentPagerAdapter mContentAdapter;

    private BaseFragment mTargetFragment;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);

        setTitle(""); // 容器片段，页面标题为空字符

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        mContentAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager());
        // 初始化2个tab
        mTabLayout.addTab(mTabLayout.newTab());
        SportsFragment sports = SportsFragment.newInstance("", "");
        sports.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("运动", sports);
//        sports.setTitle(mContentAdapter.getPageTitle(0)); // 容器片段，页面标题为空字符

        mTabLayout.addTab(mTabLayout.newTab());
        DetailFragment detail = DetailFragment.newInstance("", "");
        detail.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("详情", detail);
        detail.setTitle(mContentAdapter.getPageTitle(1));

        // ViewPager默认加载页面的左右两页，此方法设置屏幕外左右加载页数
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mContentAdapter);
        mTabLayout.setupWithViewPager(mViewPager); // 定制TabItem会被删除
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                mTargetFragment = (BaseFragment) mContentAdapter.getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        // 设置默认选中
        mViewPager.setCurrentItem(0);
        mTabLayout.getTabAt(0).select();
        mTargetFragment = (BaseFragment) mContentAdapter.getItem(0);
    }

    @Override
    public boolean onBackPressed() {
        // 检查当前Fragment内部是否有待处理的回退逻辑
        return mTargetFragment != null && mTargetFragment.onBackPressed();
    }

    @Override
    public void onVisibilityChangedToUser(boolean isVisibleToUser, String method) {
        Log.d(this);
        super.onVisibilityChangedToUser(isVisibleToUser, method);

        // 子视图可见性
        if (mContentAdapter == null || mViewPager == null) return;
        BaseFragment fragment = (BaseFragment) mContentAdapter.getItem(mViewPager.getCurrentItem());
        if (isVisibleToUser == fragment.isVisibleToUser()) return;
        fragment.onVisibilityChangedToUser(isVisibleToUser, TAG + "#" + method);
    }

}
