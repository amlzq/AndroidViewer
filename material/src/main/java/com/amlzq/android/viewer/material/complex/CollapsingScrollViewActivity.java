package com.amlzq.android.viewer.material.complex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amlzq.android.viewer.material.R;

/**
 * CollapsingToolbarLayout
 * NestedScrollView
 * 场景:
 * 文章详情页
 */
public class CollapsingScrollViewActivity extends AppCompatActivity {
    final String TAG = "CollapsingScrollViewActivity";

    public static Intent newIntent(Context context, String title, int cover, String summary) {
        Intent intent = new Intent(context, CollapsingScrollViewActivity.class);
        intent.putExtra("params1", title);
        intent.putExtra("params2", cover);
        intent.putExtra("params3", summary);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_scrollview);

        String title = getIntent().getStringExtra("params1");
        int cover = getIntent().getIntExtra("params2", -1);
        String summary = getIntent().getStringExtra("params3");

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(title);

        ImageView coverView = findViewById(R.id.cover);
        coverView.setImageResource(cover);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StringBuilder builder = new StringBuilder();
        builder.append(summary);
        for (int i = 0; i < 32; i++) {
            builder.append("\ndetails information.");
        }
        TextView textView = findViewById(R.id.text);
        textView.setText(builder);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.comment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
