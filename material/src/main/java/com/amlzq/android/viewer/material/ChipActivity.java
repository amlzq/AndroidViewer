package com.amlzq.android.viewer.material;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/**
 * Chip样例
 * https://material.io/develop/android/components/chip/
 */
public class ChipActivity extends AppCompatActivity
        implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener,
        ChipGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip);

        Chip chip = findViewById(R.id.chip);
        chip.setOnClickListener(this);
        chip.setOnCheckedChangeListener(this);
        chip.setOnCloseIconClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            chip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
        }

        ChipGroup chips = findViewById(R.id.chips);
        chips.setOnCheckedChangeListener(this);

        ChipGroup chips2 = findViewById(R.id.chips2);
        for (int i = 0; i < 20; i++) {
            Chip chip_ = new Chip(this);
            chip_.setText("Chip" + i);
            chips2.addView(chip_);
        }
        chips2.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.chip) {
            Toast.makeText(this, "is click", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton v, boolean isChecked) {
        if (v.getId() == R.id.chip) {
            Toast.makeText(this, isChecked ? "is checked" : "not checked", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(ChipGroup group, int checkedId) {
        int chipId = group.getCheckedChipId();
        Toast.makeText(this, "checkedId:" + checkedId + "\n,chipId:" + chipId, Toast.LENGTH_SHORT).show();
        if (group.getId() == R.id.chips) {

        } else if (group.getId() == R.id.chips2) {

        }
    }

}
