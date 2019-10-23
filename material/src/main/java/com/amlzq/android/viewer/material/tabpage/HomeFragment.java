package com.amlzq.android.viewer.material.tabpage;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.personal.MomentListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";

    // Tab + ViewPager
    private TabLayout mTabLayout;
    private List<String> mTabIndicators = new ArrayList<>();
    private ViewPager mViewPager;
    private List<Fragment> mTabFragments = new ArrayList<>();
    private ContentPagerAdapter mContentAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayout = getView().findViewById(R.id.tab_layout);
        mViewPager = getView().findViewById(R.id.view_pager);

        mContentAdapter = new ContentPagerAdapter(getChildFragmentManager());
        // 初始化tab
        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment followed = MomentListFragment.newInstance("", "");
        mTabIndicators.add("动态");
        mTabFragments.add(followed);

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment followed1 = MomentListFragment.newInstance("", "");
        mTabIndicators.add("动态");
        mTabFragments.add(followed1);

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment followed2 = MomentListFragment.newInstance("", "");
        mTabIndicators.add("动态");
        mTabFragments.add(followed2);

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment recommend = MomentListFragment.newInstance("", "");
        mTabIndicators.add("推荐");
        mTabFragments.add(recommend);

        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment recommend1 = MomentListFragment.newInstance("", "");
        mTabIndicators.add("推荐");
        mTabFragments.add(recommend1);

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
