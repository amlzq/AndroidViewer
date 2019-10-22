package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * 材料库的小部件
 */
public class WidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_material);

        findViewById(R.id.material_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content), "This is a Snackbar", Snackbar.LENGTH_SHORT)
                        .setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(WidgetActivity.this, "Snackbar is Click", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    public void onRecycleView(View view) {
        startActivity(new Intent(this, RecycleViewActivity.class));
    }

    public void onSnackbar(View view) {
        startActivity(new Intent(this, SnackbarActivity.class));
    }

    public void onToolbar(View view) {
        startActivity(new Intent(this, ToolbarActivity.class));
    }

    public void onTabLayout(View view) {
        startActivity(new Intent(this, TabLayoutActivity.class));
    }

    public void onTextView(View view) {
        startActivity(new Intent(this, TextViewActivity.class));
    }

}
