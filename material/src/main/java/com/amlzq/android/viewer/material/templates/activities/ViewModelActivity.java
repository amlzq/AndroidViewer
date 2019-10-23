package com.amlzq.android.viewer.material.templates.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.templates.activities.ui.viewmodel.ViewModelFragment;

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
