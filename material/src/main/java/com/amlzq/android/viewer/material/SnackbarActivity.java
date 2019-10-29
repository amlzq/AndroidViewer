package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

/**
 * Snackbar样例
 */
public class SnackbarActivity extends AppCompatActivity
        implements View.OnClickListener {

    Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
    }

    public void onShow(View view) {
        Snackbar.make(findViewById(android.R.id.content), "This is a Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Cancel", v -> Toast.makeText(SnackbarActivity.this, "Snackbar is Click", Toast.LENGTH_SHORT).show())
                .show();
    }

    @Override
    public void onClick(View v) {

    }

}
