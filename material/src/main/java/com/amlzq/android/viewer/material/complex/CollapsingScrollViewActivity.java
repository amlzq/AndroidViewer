package com.amlzq.android.viewer.material.complex;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amlzq.android.viewer.material.PaletteActivity;
import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.ToolbarColorizeHelper;

/**
 * CollapsingToolbarLayout
 * NestedScrollView
 * 场景:
 * 文章详情页
 */
public class CollapsingScrollViewActivity extends AppCompatActivity {
    final String TAG = "CollapsingScrollViewActivity";

    String title;
    int cover;
    String summary;

    public static Intent newIntent(Context context, String title, int cover, String summary) {
        Intent intent = new Intent(context, CollapsingScrollViewActivity.class);
        intent.putExtra("params", title);
        intent.putExtra("params2", cover);
        intent.putExtra("params3", summary);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_scrollview);

        title = getIntent().getStringExtra("params");
        cover = getIntent().getIntExtra("params2", -1);
        summary = getIntent().getStringExtra("params3");

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(title);

        ImageView coverView = findViewById(R.id.cover);
        coverView.setImageResource(cover);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Palette.from(BitmapFactory.decodeResource(getResources(), cover))
                .generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        // 获取状态栏，工具栏，工具栏文字颜色
                        int color = palette.getDominantColor(ContextCompat.getColor(CollapsingScrollViewActivity.this,
                                R.color.colorPrimary));
                        int colorDark = palette.getDarkMutedColor(color);
                        int titleTextColor = palette.getDominantSwatch().getTitleTextColor();

                        collapsingToolbar.setContentScrimColor(color);
                        collapsingToolbar.setStatusBarScrimColor(colorDark);
                        collapsingToolbar.setCollapsedTitleTextColor(titleTextColor);
                        collapsingToolbar.setExpandedTitleColor(titleTextColor);
                        ToolbarColorizeHelper.colorizeToolbar(toolbar, titleTextColor, CollapsingScrollViewActivity.this);
                    }
                });

        StringBuilder builder = new StringBuilder();
        builder.append(summary);
        builder.append("\n");
        builder.append("\n");
        builder.append("\n");
        builder.append(getString(R.string.large_text));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collapsing_scrollview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_palette) {
            Intent intent = PaletteActivity.newIntent(this, cover);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
