package com.amlzq.android.viewer.material.userhome;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.amlzq.android.viewer.MyBaseRecycleViewFragment;
import com.amlzq.android.viewer.entity.EntityInfo;
import com.amlzq.android.viewer.material.ContentAdapter;
import com.amlzq.android.viewer.material.R;

/**
 * 用户主页-动态
 * 多个界面共用此布局，所以再创建的时候设置Title
 */
public class MomentListFragment extends MyBaseRecycleViewFragment<EntityInfo, ContentAdapter.ViewHolder> {
    public static final String TAG = "MomentListFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ContentAdapter mAdapter;

    public MomentListFragment() {
        // Required empty public constructor
    }

    public static MomentListFragment newInstance(String param1, String param2) {
        MomentListFragment fragment = new MomentListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_moment_list;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        super.afterCreate(savedInstanceState);

        // 解决CollapsingToolbarLayout和RecyclerView嵌套滚动问题
        mRecyclerView.setNestedScrollingEnabled(true);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected ContentAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new ContentAdapter(mContext);
        }
        return mAdapter;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mRecyclerView.getContext());
    }

    @Override
    protected RecyclerView.ItemAnimator getItemAnimator() {
        return new DefaultItemAnimator();
    }

    @Override
    protected RecyclerView.ItemDecoration getItemDecoration() {
        // 线条分割器
        return new DividerItemDecoration(mRecyclerView.getContext(), LinearLayout.VERTICAL);
    }

    @Override
    public void onPullDownToRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //do something
                mSwipeRefresh.setRefreshing(false);
            }
        }, 3000);    //延时1s执行
    }

    @Override
    public void onDataEmptyClick() {

    }

    @Override
    public void onDataThrowableClick() {

    }

}