package com.amlzq.android.viewer;

import android.text.TextUtils;

import com.amlzq.android.app.BaseAppCompatActivity;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.Share2;
import com.amlzq.android.util.ShareContentType;

/**
 * 定制BaseAppCompatActivity
 */

public abstract class MyBaseAppCompatActivity extends BaseAppCompatActivity {

    @Override
    protected void onResume() {
        Log.d(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(this);
        super.onPause();
    }

    /**
     * 页面追踪已经开始
     */
    private boolean mPageTrackStarted = false;

    public void onVisibilityChangedToUser(boolean isVisibleToUser, String method) {

        // 页面追踪
        if (TextUtils.isEmpty(getTitle())) return;
        String pageName = getTitle().toString();
        //        String pageName = this.getClass().getSimpleName();
        if (isVisibleToUser) {
            if (!mPageTrackStarted) {
                mPageTrackStarted = true;
                Log.d("PageTrack start," + pageName + " - display - " + method);
            } else {
                Log.e("PageTrack error," + pageName + " - hidden - " + method);
            }
        } else {
            if (mPageTrackStarted) {
                mPageTrackStarted = false;
                Log.d("PageTrack end," + pageName + " - hidden - " + method);
            } else {
                Log.e("PageTrack error," + pageName + " - hidden - " + method);
            }
        }
    }

    public void goShare(String title, String url) {
        new Share2.Builder(this)
                .setContentType(ShareContentType.TEXT)
                .setTextContent(url)
                .setTitle(title)
                .build()
                .shareBySystem();
    }

}
