package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MaterialRadioButton
 */
public class RadioButtonActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {

    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_material);

        mRadioGroup = findViewById(R.id.radios);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

}