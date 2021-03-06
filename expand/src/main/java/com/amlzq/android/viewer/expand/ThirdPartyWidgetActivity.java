package com.amlzq.android.viewer.expand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.expand.fab.FloatingActionButtonActivity;
import com.amlzq.android.viewer.expand.lottie.LottieActivity;
import com.amlzq.android.viewer.expand.sidemenu.ContextMenuByYalantisActivity;
import com.amlzq.android.viewer.expand.sidemenu.SideMenuByYalantisActivity;
import com.amlzq.android.viewer.expand.smartrefresh.SmartRefreshActivity;

/**
 * https://juejin.im/post/5b70d5f0e51d45662b074d29
 * https://github.com/wasabeef/awesome-android-ui
 * http://androidxy.com/zh/page/latest/-1/0
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1020/1808.html
 * https://android-arsenal.com/
 * https://github.com/Trinea/android-open-project
 * https://www.oschina.net/project/tag/342/android-ui
 * https://greendroid.cyrilmottier.com/
 * https://fossdroid.com/
 */
public class ThirdPartyWidgetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_widget);
    }

    public void onLottie(View view) {
        startActivity(new Intent(this, LottieActivity.class));
    }

    public void onSmartRefreshLayout(View view) {
        startActivity(new Intent(this, SmartRefreshActivity.class));
    }

    public void onSideMenuByYalantis(View view) {
        startActivity(new Intent(this, SideMenuByYalantisActivity.class));
    }

    public void onFloatingButton(View view) {
        startActivity(new Intent(this, FloatingActionButtonActivity.class));
    }

    public void onContextMenuByYalantis(View view) {
        startActivity(new Intent(this, ContextMenuByYalantisActivity.class));
    }

    public void onBottomBarLayoutByChaychan(View view) {

    }

    public void onFlowLayoutHY(View view) {
    }

    public void onFlowLayoutNex3z(View view) {
    }
}
