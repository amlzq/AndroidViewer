package com.amlzq.android.viewer.material;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * SwipeRefreshLayout demo
 */
public class SwipeRefreshActivity extends AppCompatActivity
        implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.BLACK, Color.GREEN);
        // mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(this);

        // mSwipeRefreshLayout.setNestedScrollingEnabled(true);


        // mSwipeRefreshLayout.setProgressViewEndTarget(true, 0);

        // mSwipeRefreshLayout.setProgressViewOffset(false, 0, 0);

        RadioGroup size = findViewById(R.id.size);
        size.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.large) {
                    mSwipeRefreshLayout.setSize(CircularProgressDrawable.LARGE);
                } else {
                    mSwipeRefreshLayout.setSize(CircularProgressDrawable.DEFAULT);

                }
            }
        });

        CheckBox enable = findViewById(R.id.enable);
        enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSwipeRefreshLayout.setEnabled(isChecked);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> mSwipeRefreshLayout.setRefreshing(false), 6000);
    }

}
