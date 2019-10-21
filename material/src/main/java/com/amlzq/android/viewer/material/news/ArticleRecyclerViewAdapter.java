package com.amlzq.android.viewer.material.news;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.complex.CollapsingScrollViewActivity;
import com.amlzq.android.viewer.material.news.ArticleData.ArticleItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder> {

    private final List<ArticleItem> mValues;
    private final SimpleDateFormat mFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public ArticleRecyclerViewAdapter(List<ArticleItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_article, parent, false);
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
                Intent intent = CollapsingScrollViewActivity.newIntent(holder.mView.getContext(),
                        holder.mItem.title,
                        holder.mItem.cover,
                        holder.mItem.summary);
                holder.mView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
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
