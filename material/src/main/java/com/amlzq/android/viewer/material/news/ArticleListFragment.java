package com.amlzq.android.viewer.material.news;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.amlzq.android.viewer.material.R;

/**
 * 文章
 */
public class ArticleListFragment extends Fragment {

    private static final String ARG_LAYOUT_STYLE = "layout-style";
    private int mLayoutStyle = 1; // [1:LinearLayoutManager, 2:GridLayoutManager, 3:StaggeredGridLayoutManager]

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
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
            if (mLayoutStyle == 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else if (mLayoutStyle == 2) {
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            }
            ArticleRecyclerViewAdapter adapter = new ArticleRecyclerViewAdapter(ArticleData.ITEMS);
            adapter.onAttachedToRecyclerView(recyclerView);
            adapter.setItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                }
            });
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}