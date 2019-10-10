package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.amlzq.android.app.BaseAppCompatActivity;
import com.amlzq.android.viewer.material.R;

/**
 * 材料库的小部件
 */

public class WidgetDemoActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_demo_material);

        findViewById(R.id.material_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content), "This is a Snackbar", Snackbar.LENGTH_SHORT)
                        .setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(mContext, "Snackbar is Click", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

}
