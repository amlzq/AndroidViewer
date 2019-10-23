package com.amlzq.android.viewer.material;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Palette样例
 * https://github.com/shellever/Palette
 */
public class PaletteActivity extends AppCompatActivity {

    private LinearLayout mContainerLayout;

    private TextView mVibrantColorTv;
    private TextView mDarkVibrantColorTv;
    private TextView mLightVibrantColorTv;

    private TextView mMutedColorTv;
    private TextView mDarkMutedColorTv;
    private TextView mLightMutedColorTv;

    private TextView mDominantColorTv;

    public static Intent newIntent(Context context, @DrawableRes int imageResId) {
        Intent intent = new Intent(context, PaletteActivity.class);
        intent.putExtra("params", imageResId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        ImageView imageView = findViewById(R.id.image);
        mVibrantColorTv = findViewById(R.id.tv_color_vibrant);
        mDarkVibrantColorTv = findViewById(R.id.tv_color_vibrant_dark);
        mLightVibrantColorTv = findViewById(R.id.tv_color_vibrant_light);
        mMutedColorTv = findViewById(R.id.tv_color_muted);
        mDarkMutedColorTv = findViewById(R.id.tv_color_muted_dark);
        mLightMutedColorTv = findViewById(R.id.tv_color_muted_light);
        mDominantColorTv = findViewById(R.id.tv_color_dominant);
        mContainerLayout = (LinearLayout) findViewById(R.id.ll_container);

        int imageResId = getIntent().getIntExtra("params", -1);
        imageView.setImageResource(imageResId);

        // Drawable drawable = imageView.getDrawable();
        // Bitmap bitmap = drawableToBitmap(drawable);

        // Synchronous
        // mPalette = Palette.from(bitmap).generate();

        // Asynchronous
        Palette.from(BitmapFactory.decodeResource(getResources(), imageResId)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // Use generated instance
                int defaultColor = ContextCompat.getColor(PaletteActivity.this, R.color.white);

                // 鲜艳色
                int mVibrantColor = palette.getVibrantColor(defaultColor);
                int mDarkVibrantColor = palette.getDarkVibrantColor(defaultColor);
                int mLightVibrantColor = palette.getLightVibrantColor(defaultColor);
                setPaletteColor(mVibrantColorTv, mVibrantColor);
                setPaletteColor(mDarkVibrantColorTv, mDarkVibrantColor);
                setPaletteColor(mLightVibrantColorTv, mLightVibrantColor);

                // 柔和色
                int mMutedColor = palette.getMutedColor(defaultColor);
                int mDarkMutedColor = palette.getDarkMutedColor(defaultColor);
                int mLightMutedColor = palette.getLightMutedColor(defaultColor);
                setPaletteColor(mMutedColorTv, mMutedColor);
                setPaletteColor(mDarkMutedColorTv, mDarkMutedColor);
                setPaletteColor(mLightMutedColorTv, mLightMutedColor);

                // 主色，首要的，占支配地位的，显著的颜色
                int mDominantColor = palette.getDominantColor(defaultColor);
                setPaletteColor(mDominantColorTv, mDominantColor);

                // Swatch - 色块 // 15种
                List<Palette.Swatch> mSwatchList = palette.getSwatches();
                Toast.makeText(PaletteActivity.this, "Swatch num: " + mSwatchList.size(), Toast.LENGTH_SHORT).show();
                int index = -1;
                LinearLayout mSwatchesContainer = null;
                LinearLayout.LayoutParams params;
                for (Palette.Swatch swatch : mSwatchList) {
                    int color = swatch.getRgb();
                    index++;

                    if (index % 3 == 0) {
                        mSwatchesContainer = new LinearLayout(getApplicationContext());
                        mSwatchesContainer.setOrientation(LinearLayout.HORIZONTAL);
                        params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );

                        int margin = getResources().getDimensionPixelSize(R.dimen.item_margin_vertical);
                        margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                margin, getResources().getDisplayMetrics());
                        params.topMargin = margin;
                        mContainerLayout.addView(mSwatchesContainer, params);       //
                    }

                    LinearLayout mSwatchContainer = new LinearLayout(getApplicationContext());
                    mSwatchContainer.setOrientation(LinearLayout.VERTICAL);
                    params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.weight = 1;
                    params.gravity = Gravity.CENTER;
                    if (mSwatchesContainer != null) {
                        mSwatchesContainer.addView(mSwatchContainer, params);       //
                    }

                    TextView mColorTv = new TextView(getApplicationContext());
                    mColorTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                    setPaletteColor(mColorTv, color);           //
                    mColorTv.setGravity(Gravity.CENTER);
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                            30, getResources().getDisplayMetrics());
                    params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
                    params.gravity = Gravity.CENTER;
                    mSwatchContainer.addView(mColorTv, params);                 //

                    TextView mColorNameTv = new TextView(getApplicationContext());
                    mColorNameTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                    mColorNameTv.setText("Swatch " + index);
                    mColorNameTv.setGravity(Gravity.CENTER);
                    params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    params.gravity = Gravity.CENTER;
                    mSwatchContainer.addView(mColorNameTv, params);
                }
            }
        });
    }

    private void setPaletteColor(TextView tv, int color) {
        tv.setBackgroundColor(color);
        tv.setText(toRGBHexString(color));
        tv.setTextColor(parseBackgroundColor(color));
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap); // canvas -> bitmap
        //canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);      // drawable -> canvas
        return bitmap;  // drawable -> canvas -> bitmap
    }

    public static int parseBackgroundColor2(int color) {
        int counter = 0;
        counter += Color.red(color) >= 128 ? 1 : 0;
        counter += Color.green(color) >= 128 ? 1 : 0;
        counter += Color.blue(color) >= 128 ? 1 : 0;
        return counter >= 2 ? Color.BLACK : Color.WHITE;
    }

    // 通过分析背景色来决定当前文字的匹配颜色，使文字颜色自适应背景颜色
    public static int parseBackgroundColor(int color) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        if (red >= 128 && green >= 128      // 三选二
                || red >= 128 && blue >= 128
                || green >= 128 && blue >= 128) {
            return Color.rgb(0, 0, 0);
        }
        return Color.rgb(255, 255, 255);
    }

    // #FF55FF => color
    // int color = Color.parseColor("#b64242");

    // color -> #FF55FF
    public static String toRGBHexString(final int color) {
        return toRGBHexString(Color.red(color), Color.green(color), Color.blue(color));
    }

    // (r,g,b) -> #FF55FF
    public static String toRGBHexString(int red, int green, int blue) {
        return toARGBHexString(-1, red, green, blue);
    }

    // default prefix: "#"
    // (a,r,g,b) -> #FF55FF55
    public static String toARGBHexString(int alpha, int red, int green, int blue) {
        return toARGBHexString("#", alpha, red, green, blue);
    }

    public static String toARGBHexString(String prefix, int alpha, int red, int green, int blue) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        if (alpha != -1) {
            String mAlphaStr = Integer.toHexString(alpha);
            sb.append(mAlphaStr.length() == 1 ? "0" + mAlphaStr : mAlphaStr);
        }
        String mRedStr = Integer.toHexString(red);
        sb.append(mRedStr.length() == 1 ? "0" + mRedStr : mRedStr);
        String mGreenStr = Integer.toHexString(green);
        sb.append(mGreenStr.length() == 1 ? "0" + mGreenStr : mGreenStr);
        String mBlueStr = Integer.toHexString(blue);
        sb.append(mBlueStr.length() == 1 ? "0" + mBlueStr : mBlueStr);
        return sb.toString().toUpperCase();
    }

}
