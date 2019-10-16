package com.amlzq.android.viewer.holo;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.amlzq.android.viewer.holo.tab.HomeActivity;
import com.amlzq.android.viewer.holo.tab.MineActivity;
import com.amlzq.android.viewer.holo.tab.PlusActivity;

/**
 * TabHost+TabActivity
 */

public class BottomTabHostActivity
        extends TabActivity
        implements View.OnClickListener {

    private TabHost mTabHost;
    private RadioButton mHome;
    private RadioButton mPlus;
    private RadioButton mMine;

    private static final String TAB_HOME = "TAB_HOME";
    private static final String TAB_PLUS = "TAB_PLUS";
    private static final String TAB_MINE = "TAB_MINE";

    private int mSelectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab_host);
        initView();
        initClick();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mSelectedPosition = bundle.getInt("mSelectedPosition");
        } else {
            mSelectedPosition = 0;
        }
        switch (mSelectedPosition) {
            case 0:
                mTabHost.setCurrentTabByTag(TAB_HOME);
                initTextColor();
                mHome.setTextColor(Color.parseColor("#323232"));
                mHome.setChecked(true);
                break;
            case 1:
                mTabHost.setCurrentTabByTag(TAB_PLUS);
                initTextColor();
                mPlus.setTextColor(Color.parseColor("#323232"));
                mPlus.setChecked(true);
                break;
            case 2:
                mTabHost.setCurrentTabByTag(TAB_MINE);
                initTextColor();
                mMine.setTextColor(Color.parseColor("#323232"));
                mMine.setChecked(true);
                break;
        }
    }

    private void initClick() {
        mHome.setOnClickListener(this);
        mPlus.setOnClickListener(this);
        mMine.setOnClickListener(this);
    }

    private void initView() {
        mHome = findViewById(R.id.navigation_home);
        mPlus = findViewById(R.id.navigation_plus);
        mMine = findViewById(R.id.navigation_mine);
        mTabHost = getTabHost();
        Intent home = new Intent(this, HomeActivity.class);
        Intent plus = new Intent(this, PlusActivity.class);
        Intent mine = new Intent(this, MineActivity.class);

        mTabHost.addTab(mTabHost.newTabSpec(TAB_HOME).setIndicator(TAB_HOME).setContent(home));
        mTabHost.addTab(mTabHost.newTabSpec(TAB_PLUS).setIndicator(TAB_PLUS).setContent(plus));
        mTabHost.addTab(mTabHost.newTabSpec(TAB_MINE).setIndicator(TAB_MINE).setContent(mine));
    }

    public void initTextColor() {
        mHome.setTextColor(Color.parseColor("#999999"));
        mPlus.setTextColor(Color.parseColor("#999999"));
        mMine.setTextColor(Color.parseColor("#999999"));
        mHome.setChecked(false);
        mPlus.setChecked(false);
        mMine.setChecked(false);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.navigation_home) {
            initTextColor();
            mHome.setTextColor(Color.parseColor("#323232"));
            mHome.setChecked(true);
            mTabHost.setCurrentTabByTag(TAB_HOME);
        } else if (id == R.id.navigation_plus) {
            initTextColor();
            mPlus.setTextColor(Color.parseColor("#323232"));
            mPlus.setChecked(true);
            mTabHost.setCurrentTabByTag(TAB_PLUS);
        } else if (id == R.id.navigation_mine) {
            initTextColor();
            mMine.setTextColor(Color.parseColor("#323232"));
            mMine.setChecked(true);
            mTabHost.setCurrentTabByTag(TAB_MINE);
        }
    }

}
