package com.amlzq.android.viewer;

import com.amlzq.android.app.BaseActivity;
import com.amlzq.android.util.Share2;
import com.amlzq.android.util.ShareContentType;

/**
 * {@link MyConfig#IDENTIFY}BaseActivity
 */

public abstract class MyBaseActivity extends BaseActivity {

    public void goShare(String title, String url) {
        new Share2.Builder(this)
                .setContentType(ShareContentType.TEXT)
                .setTextContent(url)
                .setTitle(title)
                .build()
                .shareBySystem();
    }

}
