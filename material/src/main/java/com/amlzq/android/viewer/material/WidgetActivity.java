package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * 材料库的小部件
 *     // Toolbar和Menu
 *     // 基于CoordinatorLayout的联动
 *     // NavigationView
 *     // CardView
 *     // TextInputLayout
 *     // RecyclerView
 *     // TabLayout
 *     // SnackBar
 *     // FloatingActionButton
 *     // https://www.jianshu.com/p/776cc6329fff
 */
public class WidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_material);

        findViewById(R.id.material_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        startActivity(new Intent(this, TextFieldActivity.class));
    }

}
