package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * FloatingActionButton
 * ExtendedFloatingActionButton
 */
public class FloatingActionButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(v -> {
            // Handle the click.
            Toast.makeText(v.getContext(), "click fab", Toast.LENGTH_SHORT).show();
        });
    }

}
