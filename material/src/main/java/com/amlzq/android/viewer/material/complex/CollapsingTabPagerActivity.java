package com.amlzq.android.viewer.material.complex;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.personal.MomentListFragment;
import com.amlzq.android.viewer.material.personal.ProfileFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * AppBarLayout
 * CollapsingToolbarLayout
 * Toolbar
 * ViewPager
 * <p>
 * https://stackoverflow.com/questions/37479828/how-to-put-recyclerview-below-toolbar-and-above-tablayout-and-viewpager-also-han
 */
public class CollapsingTabPagerActivity extends AppCompatActivity {

    private AppBarLayout mAppBar;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;

    // Tab + ViewPager
    private TabLayout mTabs;
    private List<String> mIndicators = new ArrayList<>();
    private ViewPager mPagers;
    private List<Fragment> mFragments = new ArrayList<>();
    private ContentPagerAdapter mContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 装饰视图背景设置为透明
        // getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tab_pager);

        mAppBar = findViewById(R.id.appbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mCollapsingToolbar = findViewById(R.id.collapsing_toolbar);

        mTabs = findViewById(R.id.tab_layout);
        mTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getCustomView() == null) return;
                TextView textView = tab.getCustomView().findViewById(R.id.name);
                if (textView == null) return;
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setTextSize(20.0f);
                View view = tab.getCustomView().findViewById(R.id.indicator);
                if (view == null) return;
                view.setVisibility(View.VISIBLE);
                // 同步
                mPagers.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() == null) return;
                TextView textView = tab.getCustomView().findViewById(R.id.name);
                if (textView == null) return;
                textView.setTextColor(getResources().getColor(R.color.subtitleColor));
                textView.setTextSize(12.0f);
                View view = tab.getCustomView().findViewById(R.id.indicator);
                if (view == null) return;
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        mPagers = findViewById(R.id.view_pager);
        mPagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                // 同步
                mTabs.getTabAt(i).select();
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        mContentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        // 动态
        View tabView = getLayoutInflater().inflate(R.layout.tab_item_custom, null);
        TextView textView = tabView.findViewById(R.id.name);
        textView.setText("Moment");
        mTabs.addTab(mTabs.newTab().setCustomView(tabView));
        // mTabs.addTab(mTabs.newTab());
        MomentListFragment moment = MomentListFragment.newInstance("", "");
        mIndicators.add("Moment");
        mFragments.add(moment);
        // 资料
        tabView = getLayoutInflater().inflate(R.layout.tab_item_custom, null);
        textView = tabView.findViewById(R.id.name);
        textView.setText("Profile");
        mTabs.addTab(mTabs.newTab().setCustomView(tabView));
        // mTabs.addTab(mTabs.newTab());
        ProfileFragment profile = ProfileFragment.newInstance("", "");
        mIndicators.add("Profile");
        mFragments.add(profile);

        // ViewPager默认加载页面的左右两页，此方法设置屏幕外左右加载页数
        mPagers.setOffscreenPageLimit(1);
        mPagers.setAdapter(mContentAdapter);
//        mTabs.setupWithViewPager(mPagers); // 定制TabItem会被删除

        // 设置默认选中
        mPagers.setCurrentItem(0);
        mTabs.getTabAt(0).select();
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        mCollapsingToolbar.setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_personal_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item_pet_breed_two clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                // android.R.id.home是Android内置home按钮的id
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
            return mFragments.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return super.isViewFromObject(view, object);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mIndicators.get(position);
        }
    }

}