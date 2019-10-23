package com.amlzq.android.viewer.material.personal;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.amlzq.android.viewer.data.MomentData;
import com.amlzq.android.viewer.data.MomentInfo;
import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.complex.CollapsingScrollViewActivity;

/**
 * 用户主页-动态
 */
public class MomentListFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = "MomentListFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecyclerView;
    MomentRecyclerViewAdapter mAdapter;

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
        mAdapter = new MomentRecyclerViewAdapter();
        mAdapter.onAttachedToRecyclerView(mRecyclerView);
        mAdapter.setItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MomentInfo item = mAdapter.getItem(position);
                Intent intent = CollapsingScrollViewActivity.newIntent(
                        view.getContext(), item.name, item.image, item.text);
                view.getContext().startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        // 解决CollapsingToolbarLayout和RecyclerView嵌套滚动问题
        mRecyclerView.setNestedScrollingEnabled(true);

        // 添加数据
        mAdapter.setNewData(MomentData.ITEMS);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> mSwipeRefresh.setRefreshing(false), 3000);
    }

}