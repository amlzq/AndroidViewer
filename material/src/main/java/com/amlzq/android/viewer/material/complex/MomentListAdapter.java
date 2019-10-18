package com.amlzq.android.viewer.material.complex;

import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.viewer.material.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户动态列表适配器
 */
public class MomentListAdapter extends RecyclerView.Adapter<MomentListAdapter.ViewHolder> {

    private List<MomentInfo> mValues = new ArrayList<>();

    public MomentListAdapter() {
    }

    public void addData(List<MomentInfo> items) {
        mValues.addAll(items);
    }

    public void setNewData(List<MomentInfo> items) {
        mValues.clear();
        mValues.addAll(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_moment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mAvatar.setImageResource(holder.mItem.avatar);
        holder.mName.setText(holder.mItem.name);
        holder.mText.setText(holder.mItem.text);
        holder.mImage.setImageResource(holder.mItem.image);
        if (holder.mItem.liked) {
            holder.mLike.setImageResource(holder.mItem.image);
        } else {
            holder.mLike.setImageResource(holder.mItem.image);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final AppCompatImageView mAvatar;
        public final AppCompatTextView mName;
        public final AppCompatTextView mText;
        public final AppCompatImageView mImage;
        public final AppCompatImageButton mLike;
        public final MaterialButton mComment;
        public MomentInfo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mAvatar = view.findViewById(R.id.avatar);
            mName = view.findViewById(R.id.name);
            mText = view.findViewById(R.id.text);
            mImage = view.findViewById(R.id.image);
            mLike = view.findViewById(R.id.like);
            mComment = view.findViewById(R.id.comment);
        }
    }

}