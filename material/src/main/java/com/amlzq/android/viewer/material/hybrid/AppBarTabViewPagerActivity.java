package com.amlzq.android.viewer.material.hybrid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.log.Log;
import com.amlzq.android.material.AppBarStateChangeListener;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.viewer.MyBaseAppCompatActivity;
import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.userhome.MomentListFragment;
import com.amlzq.android.viewer.material.userhome.ProfileBoardFragment;

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
public class AppBarTabViewPagerActivity extends MyBaseAppCompatActivity {

    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;

    // Tab + ViewPager
    private TabLayout mTabLayout;
    private List<String> mTabIndicators;
    private ViewPager mViewPager;
    private List<Fragment> mTabFragments;
    private ContentPagerAdapter mContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 装饰视图背景设置为透明
        // getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tab_viewpager);

        mAppBarLayout = findViewById(R.id.appbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d(state.name());
                if (state == State.EXPANDED) {
                    //展开状态

                } else if (state == State.COLLAPSED) {
                    //折叠状态

                } else {
                    //中间状态

                }
            }
        });

        mTabLayout = findViewById(R.id.tab);
        mTabIndicators = new ArrayList<>();
        mViewPager = findViewById(R.id.view_pager);
        mTabFragments = new ArrayList<>();

        mContentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        // 初始化2个tab
        mTabLayout.addTab(mTabLayout.newTab());
        MomentListFragment moment = MomentListFragment.newInstance("", "");
        moment.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mTabIndicators.add("动态");
        mTabFragments.add(moment);
        moment.setTitle(mContentAdapter.getPageTitle(0));

        mTabLayout.addTab(mTabLayout.newTab());
        ProfileBoardFragment profile = ProfileBoardFragment.newInstance("", "");
        profile.setTransactionOpCmd(FragmentLauncher.FLAG_ATTACH_DETACH_ADD_REMOVE);
        mTabIndicators.add("关于我");
        mTabFragments.add(profile);
        profile.setTitle(mContentAdapter.getPageTitle(1));

        // ViewPager默认加载页面的左右两页，此方法设置屏幕外左右加载页数
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mContentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
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

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(requestCode + "," + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {

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