package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.app.BaseAppCompatActivity;
import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.anim.lottie.LottieActivity;

/**
 * 材料设计的布局演示样例
 */
public class LayoutDemoActivity extends BaseAppCompatActivity {

    TextView mTVInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // android:fitsSystemWindows="true"
        setContentView(R.layout.activity_layout_demo_material);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("我是标题");
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true); // 决定左上角图标的右侧是否有向左的小箭头, true // 有小箭头，并且图标可以点击
            actionBar.setIcon(R.drawable.ic_menu_camera_default);
            actionBar.setLogo(R.drawable.ic_menu_share_default);
        }

        // force use of overflow menu on devices with menu button
        // 在actionbar中显示溢出菜单选项
        // http://stackoverflow.com/questions/9286822/how-to-force-use-of-overflow-menu-on-devices-with-menu-button
//        try {
//            ViewConfiguration config = ViewConfiguration.get(this);
//            Field menuKeyField = ViewConfiguration.class.getDeclaredField(sHasPermanentMenuKey);
//            if (menuKeyField != null) {
//                menuKeyField.setAccessible(true);
//                menuKeyField.setBoolean(config, false);
//            }
//        } catch (Exception ex) {
//            // Ignore
//        }

        mTVInfo = findViewById(R.id.tv_info);

        mTVInfo.setText("TAG:" + mUniqueTag);
        Log.e(mUniqueTag, "查看标签");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                showToastShort("返回键响应");
                // this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (isShowLoading()) {
            closeLoadingDilaog();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
//            WindowUtil.enableLeanbackMode(getWindow());
//            WindowUtil.enableImmersiveMode(getWindow());
//            WindowUtil.enableStickyImmersiveMode(getWindow());
        }
    }

    public void onButtonEvent(View view) {
//        WindowUtil.showSystemUI(getWindow());

//        showErrorSnackbar(findViewById(R.id.rl_content), "错误信息");

//        showLoadingDilaog("加载中");

        startActivity(new Intent(mContext, LottieActivity.class));
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {

    }

}
