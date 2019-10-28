package com.amlzq.android.viewer.material;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * https://github.com/google/flexbox-layout
 */
public class FlexboxLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox_layout);
    }

    public void onRecyclerView(View view) {
        startActivity(new Intent(this, FlexboxRecycleViewActivity.class));
    }
}
