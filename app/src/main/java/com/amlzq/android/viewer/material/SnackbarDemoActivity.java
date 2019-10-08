package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.amlzq.android.viewer.R;

public class SnackbarDemoActivity extends AppCompatActivity {

    Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar_demo);
    }

}
