package com.amlzq.android.viewer.material.tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.app.SimpleFragmentPagerAdapter;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.userhome.MomentListFragment;

/**
 * 首页
 */
public class HomeFragment extends MyBaseFragment {
    public static final String TAG = "HomeFragment";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SimpleFragmentPagerAdapter mContentAdapter;

    private BaseFragment mTargetFragment;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);

        setTitle(""); // 容器片段，页面标题为空字符

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        mContentAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager());
        // 初始化tab
        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment followed = MomentListFragment.newInstance("", "");
        followed.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("动态", followed);
        followed.setTitle(mContentAdapter.getPageTitle(0));

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment followed1 = MomentListFragment.newInstance("", "");
        followed1.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("动态", followed1);
        followed1.setTitle(mContentAdapter.getPageTitle(1));

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment followed2 = MomentListFragment.newInstance("", "");
        followed2.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("动态", followed2);
        followed2.setTitle(mContentAdapter.getPageTitle(2));

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment recommend = MomentListFragment.newInstance("", "");
        recommend.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("推荐", recommend);
        recommend.setTitle(mContentAdapter.getPageTitle(3));

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment recommend1 = MomentListFragment.newInstance("", "");
        recommend1.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("推荐", recommend1);
        recommend1.setTitle(mContentAdapter.getPageTitle(4));

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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
