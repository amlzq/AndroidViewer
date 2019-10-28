package com.amlzq.android.viewer.material.news;

import android.content.Intent;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.complex.CollapsingScrollViewActivity;
import com.amlzq.android.viewer.material.news.ArticleData.ArticleItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder> {

    private final List<ArticleItem> mValues = new ArrayList<>();
    private final SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private RecyclerView mRecyclerView;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemLongClickListener mItemLongClickListener;

    public ArticleRecyclerViewAdapter() {
    }

    public void setNewData(List<ArticleItem> items) {
        mValues.clear();
        mValues.addAll(items);
    }

    public void onAttachedToRecyclerView(RecyclerView view) {
        mRecyclerView = view;
    }

    public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setItemLongClickListener(AdapterView.OnItemLongClickListener itemLongClickListener) {
        this.mItemLongClickListener = itemLongClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        switch (getItem(position).viewType) {
            case ArticleData.VIEW_TYPE_GRID:
                return 2;
            case ArticleData.VIEW_TYPE_STAGGERED:
                return 3;
            case ArticleData.VIEW_TYPE_FLEXBOX:
                return 4;
            default:
                return 1;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutResId = R.layout.fragment_article_linear;
        if (viewType == 2) {
            layoutResId = R.layout.fragment_article_grid;
        } else if (viewType == 3) {
            layoutResId = R.layout.fragment_article_staggered;
        } else if (viewType == 4) {
            layoutResId = R.layout.fragment_article_flexbox;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mCoverView.setImageResource(mValues.get(position).cover);
        holder.mTitleView.setText(mValues.get(position).title);
        holder.mSummaryView.setText(mValues.get(position).summary);
        String date = mFormat.format(new Date(mValues.get(position).time));
        holder.mTimeView.setText(date);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CollapsingScrollViewActivity.newIntent(
                        holder.mView.getContext(),
                        holder.mItem.title,
                        holder.mItem.cover,
                        holder.mItem.summary);
                holder.mView.getContext().startActivity(intent);
            }
        });

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.mCoverView.getLayoutParams();
        if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                    holder.mCoverView.getContext().getResources().getDisplayMetrics());
            params.height = height;
        } else if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                    holder.mCoverView.getContext().getResources().getDisplayMetrics());
            height = (int) (height + (position % 3) * 0.0f * 30);
            params.height = height;
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public ArticleItem getItem(int position) {
        return mValues.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mCoverView;
        public final TextView mTitleView;
        public final TextView mSummaryView;
        public final TextView mTimeView;
        public ArticleItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCoverView = (ImageView) view.findViewById(R.id.cover);
            mTitleView = (TextView) view.findViewById(R.id.title);
            mSummaryView = (TextView) view.findViewById(R.id.summary);
            mTimeView = (TextView) view.findViewById(R.id.time);
        }
    }

}
