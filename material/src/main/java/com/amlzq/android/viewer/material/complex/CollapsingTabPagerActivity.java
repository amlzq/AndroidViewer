package com.amlzq.android.viewer.material.complex;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.personal.MomentListFragment;
import com.amlzq.android.viewer.material.personal.ProfileFragment;

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

    // Tab + ViewPager
    private TabLayout mTabs;
    private List<String> mTabIndicators = new ArrayList<>();
    private ViewPager mViewPager;
    private List<Fragment> mTabFragments = new ArrayList<>();
    private ContentPagerAdapter mContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 装饰视图背景设置为透明
        // getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tab_pager);

        mAppBar = findViewById(R.id.appbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mTabs = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.view_pager);

        mContentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        // 初始化2个tab
        mTabs.addTab(mTabs.newTab());
        MomentListFragment moment = MomentListFragment.newInstance("", "");
        mTabIndicators.add("Moment");
        mTabFragments.add(moment);

        mTabs.addTab(mTabs.newTab());
        ProfileFragment profile = ProfileFragment.newInstance("", "");
        mTabIndicators.add("Profile");
        mTabFragments.add(profile);

        // ViewPager默认加载页面的左右两页，此方法设置屏幕外左右加载页数
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mContentAdapter);
        mTabs.setupWithViewPager(mViewPager);
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