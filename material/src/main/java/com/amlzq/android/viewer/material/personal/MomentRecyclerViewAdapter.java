package com.amlzq.android.viewer.material.personal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.amlzq.android.viewer.data.MomentInfo;
import com.amlzq.android.viewer.material.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户动态列表适配器
 */
public class MomentRecyclerViewAdapter extends RecyclerView.Adapter<MomentRecyclerViewAdapter.ViewHolder> {

    private List<MomentInfo> mValues = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private AdapterView.OnItemClickListener mItemClickListener;

    public MomentRecyclerViewAdapter() {
    }

    public void onAttachedToRecyclerView(RecyclerView view) {
        mRecyclerView = view;
    }

    public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void addData(List<MomentInfo> items) {
        mValues.addAll(items);
    }

    public void setNewData(List<MomentInfo> items) {
        mValues.clear();
        mValues.addAll(items);
    }

    public MomentInfo getItem(int position) {
        return mValues.get(position);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.mLike.setImageTintList(createColorStateList(
                    R.color.black,
                    R.color.colorAccent,
                    R.color.colorPrimary,
                    R.color.gray));
        }
        if (holder.mItem.liked) {
            holder.mLike.setPressed(true);
        } else {
            holder.mLike.setPressed(false);
        }

        holder.mView.setOnClickListener(v -> {
            mItemClickListener.onItemClick(null,
                    v,
                    holder.getAdapterPosition(),
                    holder.getItemId());
        });
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
        public final AppCompatImageButton mComment;
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

    private ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        ColorStateList list = new ColorStateList(states, colors);
        return list;
    }

    private StateListDrawable getSelector(Context context, int idNormal, int idPressed, int idFocused,
                                          int idUnable) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);
        Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);
        Drawable focused = idFocused == -1 ? null : context.getResources().getDrawable(idFocused);
        Drawable unable = idUnable == -1 ? null : context.getResources().getDrawable(idUnable);
        // View.PRESSED_ENABLED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressed);
        // View.ENABLED_FOCUSED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, focused);
        // View.ENABLED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_enabled}, normal);
        // View.FOCUSED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_focused}, focused);
        // View.WINDOW_FOCUSED_STATE_SET
        drawable.addState(new int[]{android.R.attr.state_window_focused}, unable);
        // View.EMPTY_STATE_SET
        drawable.addState(new int[]{}, normal);
        return drawable;
    }

}