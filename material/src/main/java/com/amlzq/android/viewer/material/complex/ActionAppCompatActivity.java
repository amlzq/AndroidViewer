package com.amlzq.android.viewer.material.complex;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.personal.MomentListFragment;
import com.amlzq.android.viewer.material.personal.ProfileFragment;

/**
 * 详细活动页
 * 头部固定为：返回，标题，菜单
 * 使用了Toolbar，需要NoActionBar样式
 */
public class ActionAppCompatActivity extends AppCompatActivity {
    public static final String TAG = "ActionAppCompatActivity";

    private Toolbar mToolbar;
    private TextView mTitle; // 居中的标题

    public static Intent newIntent(Context context, String tag) {
        Intent intent = new Intent(context, ActionAppCompatActivity.class);
        intent.putExtra("params", tag);
        return intent;
    }

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

        String fragmentTag = getIntent().getStringExtra("params");
        fragmentProvider(fragmentTag);
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

    private Fragment fragmentProvider(String fragmentTag) {
        if (ProfileFragment.TAG.equals(fragmentTag)) {
            ProfileFragment fragment = ProfileFragment.newInstance("", "");
            return fragment;

        } else if (DetailFragment.TAG.equals(fragmentTag)) {
            DetailFragment fragment = DetailFragment.newInstance("", "");
            return fragment;

        } else if (MomentListFragment.TAG.equals(fragmentTag)) {
            MomentListFragment fragment = MomentListFragment.newInstance("", "");
            return fragment;

        } else {
            return null;
        }
    }

}