package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amlzq.android.viewer.material.complex.MaterialComplexActivity;
import com.amlzq.android.viewer.material.templates.TemplatesActivity;

/**
 * material design
 * 材料设计
 */

public class MaterialDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        TextView textView = findViewById(R.id.tv_message);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.material_design, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_official) {
            Intent intent = WebActivity.newIntent(this, "https://material.io/");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onComponents(View view) {
        startActivity(new Intent(this, ComponentsActivity.class));
    }

    public void onDayNight(View view) {

    }

    public void onComplex(View view) {
        startActivity(new Intent(this, MaterialComplexActivity.class));
    }

    public void onTemplates(View view) {
        startActivity(new Intent(this, TemplatesActivity.class));
    }

    public void onDocumentation(View view) {
        Intent intent = WebActivity.newIntent(this, "https://material.io/develop/android/docs/building-from-source/");
        startActivity(intent);
    }

    public void onTheming(View view) {
    }

}
