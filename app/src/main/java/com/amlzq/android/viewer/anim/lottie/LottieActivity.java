package com.amlzq.android.viewer.anim.lottie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.amlzq.android.viewer.R;

/**
 * AE制作的视频导出json
 * http://airbnb.io/lottie/android/android.html
 */
public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setImageAssetsFolder("images/");
        animationView.setAnimation("shanping.json");
        animationView.loop(true);
        animationView.playAnimation();

    }

}