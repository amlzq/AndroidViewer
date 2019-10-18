package com.amlzq.android.viewer.material.complex;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.amlzq.android.viewer.material.R;

/**
 * 用户主页-动态
 */
public class MomentListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "MomentListFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecyclerView;
    MomentListAdapter mAdapter;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_moment_list, container, false);
        mSwipeRefresh = rootView.findViewById(R.id.swipe_refresh);
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 下拉刷新
        mSwipeRefresh.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mSwipeRefresh.setOnRefreshListener(this);

        // 设置列表
        // 项动画
        DefaultItemAnimator animator = new DefaultItemAnimator();
        mRecyclerView.setItemAnimator(animator);
        // 项装饰
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(mRecyclerView.getContext(), LinearLayout.VERTICAL);
        mRecyclerView.addItemDecoration(decoration);
        // 项布局
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mRecyclerView.getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
//            mRecyclerView.setNestedScrollingEnabled(false); // 是否允许滚动联动 appbar_scrolling_view_behavior
        mAdapter = new MomentListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        // 解决CollapsingToolbarLayout和RecyclerView嵌套滚动问题
        mRecyclerView.setNestedScrollingEnabled(true);

        // mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //do something
                mSwipeRefresh.setRefreshing(false);
            }
        }, 3000);    //延时1s执行
    }

}