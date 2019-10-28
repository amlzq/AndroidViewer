package com.amlzq.android.viewer.expand.lottie;

import android.app.Activity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.amlzq.android.viewer.expand.R;

/**
 * AE制作的视频导出json
 */
public class LottieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        // TODO: 2019/10/28 资源丢失
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setImageAssetsFolder("images/");
        animationView.setAnimation("shanping.json");
        animationView.loop(true);
        animationView.playAnimation();
    }

}