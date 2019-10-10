package com.amlzq.android.viewer.material.tab;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.app.SimpleFragmentPagerAdapter;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.viewer.MyBaseContainerFragment;
import com.amlzq.android.viewer.material.R;

/**
 * 运动
 */
public class SportsFragment extends MyBaseContainerFragment {
    public static final String TAG = "SportsFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SimpleFragmentPagerAdapter mContentAdapter;

    private BaseFragment mTargetFragment;


    public SportsFragment() {
        // Required empty public constructor
    }

    public static SportsFragment newInstance(String param1, String param2) {
        SportsFragment fragment = new SportsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_sports;
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
        RunFragment run = RunFragment.newInstance("", "");
        run.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("跑步", run);
        run.setTitle(mContentAdapter.getPageTitle(0));

        mTabLayout.addTab(mTabLayout.newTab());
        SwimFragment swim = SwimFragment.newInstance("", "");
        swim.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mContentAdapter.addTab("游泳", swim);
        swim.setTitle(mContentAdapter.getPageTitle(1));

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
        Log.d("onVisibilityChangedToUser#" + isVisibleToUser);
        super.onVisibilityChangedToUser(isVisibleToUser, method);

        // 子视图可见性
        if (mContentAdapter == null || mViewPager == null) return;
        BaseFragment fragment = (BaseFragment) mContentAdapter.getItem(mViewPager.getCurrentItem());
        if (isVisibleToUser == fragment.isVisibleToUser()) return;
        fragment.onVisibilityChangedToUser(isVisibleToUser, TAG + "#" + method);
    }

}
