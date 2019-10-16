package com.amlzq.android.viewer.material.templates_v320.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.templates_v320.activities.ui.viewmodel.ViewModelFragment;

public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_model_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ViewModelFragment.newInstance())
                    .commitNow();
        }
    }
}
