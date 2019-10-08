package com.amlzq.android.viewer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.app.BaseFragment;
import com.amlzq.android.log.Log;
import com.amlzq.android.util.Share2;
import com.amlzq.android.util.ShareContentType;

/**
 * 定制BaseFragment
 */

public abstract class MyBaseFragment extends BaseFragment {

    @Override
    public void onAttach(Context context) {
        Log.d(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(this);
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(this);
        super.onResume();
//        Log.i("dump start");
//        dump("", null, new PrintWriter(System.out, true), null);
//        Log.i("dump end");
    }

    @Override
    public void onPause() {
        Log.d(this);
        super.onPause();
//        Log.i("dump start");
//        dump("", null, new PrintWriter(System.out, true), null);
//        Log.i("dump end");
    }

    @Override
    public void onStop() {
        Log.d(this);
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(this);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(this);
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(this);
        super.onDetach();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.d(this);
        super.onHiddenChanged(hidden);
//        Log.i("dump start");
//        dump("", null, new PrintWriter(System.out, true), null);
//        Log.i("dump end");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.d(this);
        super.setUserVisibleHint(isVisibleToUser);
//        Log.i("dump start");
//        dump("", null, new PrintWriter(System.out, true), null);
//        Log.i("dump end");
    }

    public void goShare(String title, String url) {
        new Share2.Builder(mActivity)
                .setContentType(ShareContentType.TEXT)
                .setTextContent(url)
                .setTitle(title)
                .build()
                .shareBySystem();
    }

    /**
     * 页面追踪已经开始
     */
    private boolean mPageTrackStarted = false;

    @Override
    public void onVisibilityChangedToUser(boolean isVisibleToUser, String method) {
        super.onVisibilityChangedToUser(isVisibleToUser, method);

        // 页面追踪
        if (TextUtils.isEmpty(getTitle())) return;
        String pageName = getTitle().toString();
        //        String pageName = this.getClass().getSimpleName();
        if (isVisibleToUser) {
            if (!mPageTrackStarted) {
                mPageTrackStarted = true;
                Log.d("PageTrack start," + pageName + " - display - " + method);
            } else {
                Log.e("PageTrack error," + pageName + " - display - " + method);
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

    @Override
    protected void afterCreate(Bundle bundle) {
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
