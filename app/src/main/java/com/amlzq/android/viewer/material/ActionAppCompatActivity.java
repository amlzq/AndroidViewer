package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.ApplicationConstant;
import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.ActivityUtil;
import com.amlzq.android.util.FragmentLauncher;
import com.amlzq.android.viewer.MyBaseAppCompatActivity;
import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.material.tab.DetailFragment;
import com.amlzq.android.viewer.material.userhome.AboutUserFragment;
import com.amlzq.android.viewer.material.userhome.MomentListFragment;

/**
 * 详细活动页
 * 头部固定为：返回，标题，菜单
 * 使用了Toolbar，需要NoActionBar样式
 */
public class ActionAppCompatActivity extends MyBaseAppCompatActivity {
    public static final String TAG = "ActionAppCompatActivity";

    private Toolbar mToolbar;
    private TextView mTitle; // 居中的标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_app_compat);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false); // 设置不显示Title
//            actionBar.setHomeAsUpIndicator(R.drawable.icon_person); // 自定义图标
        }
        mTitle = findViewById(R.id.tv_title);
        mTitle.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        mTitle.setVisibility(View.GONE);

        mTargetFragmentTag = mBundle.getString(ActivityUtil.FRAGMENT_TAG);
        startFragment(mTargetFragmentTag);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.action, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (mTitle.getVisibility() == View.VISIBLE) {
            mTitle.setText(title);
        } else {
            mToolbar.setTitle(title);
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
    protected BaseFragment fragmentProvider(String fragmentTag, String... args) {
        if (AboutUserFragment.TAG.equals(fragmentTag)) {
            AboutUserFragment fragment = AboutUserFragment.newInstance("", "");
            fragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
            fragment.setTitle(fragmentTag);
            return fragment;

        } else if (DetailFragment.TAG.equals(fragmentTag)) {
            DetailFragment fragment = DetailFragment.newInstance("", "");
            fragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
            fragment.setTitle(fragmentTag);
            return fragment;

        } else if (MomentListFragment.TAG.equals(fragmentTag)) {
            MomentListFragment fragment = MomentListFragment.newInstance("", "");
            fragment.setTransactionOpCmd(FragmentLauncher.FLAG_ADD_REMOVE_HIDE_SHOW);
            fragment.setTitle(fragmentTag);
            return fragment;

        } else {
            return super.fragmentProvider(fragmentTag, args);
        }
    }

}