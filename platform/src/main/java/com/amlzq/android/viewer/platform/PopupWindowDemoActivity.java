package com.amlzq.android.viewer.platform;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * PopupWindow样例
 */
public class PopupWindowDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_demo);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {

        });
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.showAsDropDown(button);
    }

}
