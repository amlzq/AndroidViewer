package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MaterialButton样例
 */
public class MaterialButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_button);

        findViewById(R.id.material_button).setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "click material button", Toast.LENGTH_SHORT).show();
        });
    }

}
