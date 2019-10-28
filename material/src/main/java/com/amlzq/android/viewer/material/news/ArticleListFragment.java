package com.amlzq.android.viewer.material.news;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.complex.OnItemChildClickListener;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

/**
 * 文章
 */
public class ArticleListFragment extends Fragment
        implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener,
        OnItemChildClickListener {

    private static final String ARG_LAYOUT_STYLE = "layout-style";
    private int mLayoutStyle = 1; // [1:LinearLayoutManager, 2:GridLayoutManager, 3:StaggeredGridLayoutManager, 4:Flexbox]

    public ArticleListFragment() {
    }

    public static ArticleListFragment newInstance(int layoutStyle) {
        ArticleListFragment fragment = new ArticleListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_STYLE, layoutStyle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mLayoutStyle = getArguments().getInt(ARG_LAYOUT_STYLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setHasFixedSize(true);
            ArticleRecyclerViewAdapter adapter = new ArticleRecyclerViewAdapter();

            if (mLayoutStyle == 2) {
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                adapter.setNewData(ArticleData.generateData(12, ArticleData.VIEW_TYPE_GRID));
            } else if (mLayoutStyle == 3) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                adapter.setNewData(ArticleData.generateData(25, ArticleData.VIEW_TYPE_STAGGERED));
            } else if (mLayoutStyle == 4) {
                FlexboxLayoutManager manager = new FlexboxLayoutManager(recyclerView.getContext());
                manager.setFlexDirection(FlexDirection.COLUMN);
                manager.setJustifyContent(JustifyContent.FLEX_END);
                recyclerView.setLayoutManager(manager);
                adapter.setNewData(ArticleData.generateData(12, ArticleData.VIEW_TYPE_FLEXBOX));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                adapter.setNewData(ArticleData.generateData(25, ArticleData.VIEW_TYPE_LINEAR));
            }
            adapter.onAttachedToRecyclerView(recyclerView);
            adapter.setItemClickListener(this);
            adapter.setItemLongClickListener(this);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override
    public void onItemChildClick(View view, int position) {

    }

}