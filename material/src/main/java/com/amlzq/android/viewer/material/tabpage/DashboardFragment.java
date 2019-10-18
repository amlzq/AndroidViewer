package com.amlzq.android.viewer.material.tabpage;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.complex.DetailFragment;
import com.amlzq.android.viewer.material.sports.SportsFragment;

import java.util.List;

/**
 * 仪表板
 */
public class DashboardFragment extends Fragment {
    public static final String TAG = "DashboardFragment";

    // Tab + ViewPager
    private TabLayout mTabLayout;
    private List<String> mTabIndicators;
    private ViewPager mViewPager;
    private List<Fragment> mTabFragments;
    private ContentPagerAdapter mContentAdapter;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayout = getView().findViewById(R.id.tab_layout);
        mViewPager = getView().findViewById(R.id.view_pager);

        mContentAdapter = new ContentPagerAdapter(getChildFragmentManager());
        // 初始化2个tab
        mTabLayout.addTab(mTabLayout.newTab());
        SportsFragment sports = SportsFragment.newInstance("", "");
        mTabIndicators.add("运动");
        mTabFragments.add(sports);

        mTabLayout.addTab(mTabLayout.newTab());
        DetailFragment detail = DetailFragment.newInstance("", "");
        mTabIndicators.add("详情");
        mTabFragments.add(detail);

        // ViewPager默认加载页面的左右两页，此方法设置屏幕外左右加载页数
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mContentAdapter);
        mTabLayout.setupWithViewPager(mViewPager); // 定制TabItem会被删除

        // 设置默认选中
        mViewPager.setCurrentItem(0);
        mTabLayout.getTabAt(0).select();
    }

    /**
     * 片段适配器
     */
    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {
            return mTabFragments.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return super.isViewFromObject(view, object);
        }

        @Override
        public int getCount() {
            return mTabFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabIndicators.get(position);
        }
    }

}
