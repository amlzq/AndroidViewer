package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.viewer.material.complex.MaterialComplexActivity;
import com.amlzq.android.viewer.material.templates.TemplatesActivity;

/**
 * material design style guide
 * 材料设计风格的指南
 * <p>
 * https://material.io/develop/android/components
 * https://blog.csdn.net/kong_gu_you_lan/article/details/80755159
 */

public class MaterialDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        TextView textView = findViewById(R.id.tv_message);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public void onLayout(View view) {
        startActivity(new Intent(this, LayoutActivity.class));
    }

    // Toolbar和Menu
    // 基于CoordinatorLayout的联动
    // NavigationView
    // CardView
    // TextInputLayout
    // RecyclerView
    // TabLayout
    // SnackBar
    // FloatingActionButton
    // https://www.jianshu.com/p/776cc6329fff

    public void onWidget(View view) {
        startActivity(new Intent(this, WidgetActivity.class));
    }

    public void onDayNight(View view) {

    }

    public void onComplex(View view) {
        startActivity(new Intent(this, MaterialComplexActivity.class));
    }

    public void onTemplates(View view) {
        startActivity(new Intent(this, TemplatesActivity.class));
    }

    public void onPalette(View view) {
        Intent intent = PaletteActivity.newIntent(this,
                R.drawable.ippawards_49_1st_sunset_sreekumar_krishnan);
        startActivity(intent);
    }

    public void onChip(View view) {
        startActivity(new Intent(this, ChipActivity.class));
    }
}
