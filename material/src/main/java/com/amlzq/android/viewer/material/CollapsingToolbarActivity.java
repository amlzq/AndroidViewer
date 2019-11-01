package com.amlzq.android.viewer.material;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

/**
 * CollapsingToolbarLayout样例
 */
public class CollapsingToolbarActivity extends AppCompatActivity {

    CollapsingToolbarLayout mCollapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        mCollapsingToolbar = findViewById(R.id.collapsing_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView cover = findViewById(R.id.cover);
        SeekBar seekBar = findViewById(R.id.seek_collapse_parallax);
        RadioGroup radioGroup = findViewById(R.id.title);

        setSupportActionBar(toolbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                float multiplier = progress / 100f;
//                CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) cover.getLayoutParams();
//                params.setParallaxMultiplier(multiplier);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio) {
                    toolbar.setTitle("");
                    mCollapsingToolbar.setTitle("Title at collapsing toolbar");
                    mCollapsingToolbar.setTitleEnabled(true);
                } else {
                    toolbar.setTitle("Title at toolbar");
                    mCollapsingToolbar.setTitle("");
                    mCollapsingToolbar.setTitleEnabled(false);
                }
            }
        });
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        mCollapsingToolbar.setTitle(title);
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }

}
