package com.amlzq.android.viewer.material;

import android.os.Build;
import android.os.Bundle;
import com.google.android.material.chip.Chip;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

/**
 * ChipGroup样例
 */
public class ChipActivity extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip);

        Chip chip = (Chip) findViewById(R.id.chip);
        chip.setOnClickListener(this);
        chip.setOnCheckedChangeListener(this);
        chip.setOnCloseIconClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            chip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
        }

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

}
