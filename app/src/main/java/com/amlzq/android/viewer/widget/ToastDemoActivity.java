package com.amlzq.android.viewer.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.amlzq.android.viewer.R;

public class ToastDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_demo);
        initToast();
    }

    Toast mToast;
    StringBuffer stringBuffer;

    private void initToast() {
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT); // 必须通过makeText创建对象
        stringBuffer = new StringBuffer();
        RadioGroup mToastTime = findViewById(R.id.rg_time);
        RadioGroup mToastPosition = findViewById(R.id.rg_position);
        mToastTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_short) {
                    stringBuffer.append("short,");
                    mToast.setDuration(Toast.LENGTH_SHORT);
                }
                if (checkedId == R.id.rb_long) {
                    stringBuffer.append("long,");
                    mToast.setDuration(Toast.LENGTH_LONG);
                }
            }
        });
        mToastPosition.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_top) {
                    stringBuffer.append("top,");
                    mToast.setGravity(Gravity.TOP, 0, 0);
                }
                if (checkedId == R.id.rb_center) {
                    stringBuffer.append("center,");
                    mToast.setGravity(Gravity.CENTER, 0, 0);
                }
                if (checkedId == R.id.rb_bottom) {
                    stringBuffer.append("bottom,");
                    mToast.setGravity(Gravity.BOTTOM, 0, 0);
                }
            }
        });
    }

    public void onToast(View view) {
        mToast.setText(stringBuffer.toString());
        mToast.show();
    }

}
