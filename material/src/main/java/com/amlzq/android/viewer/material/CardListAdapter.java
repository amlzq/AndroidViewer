package com.amlzq.android.viewer.material;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amlzq.android.view.OnItemChildClickListener;
import com.amlzq.android.view.OnItemClickListener;
import com.amlzq.android.viewer.entity.EntityInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡片试图列表适配器
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    private Context mContext;
    private List<EntityInfo> mDatas = new ArrayList<>();
    private OnItemClickListener mItemClickListener;
    private OnItemChildClickListener mItemChildClickListener;

    public CardListAdapter(Context context, List<EntityInfo> datas) {
        mContext = context;
        mDatas.addAll(datas);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mView.setTag(holder);
        holder.mItem = getItem(position);
        holder.mTitle.setText(holder.mItem.getId());
        holder.mContent.setText(holder.mItem.getContent());
        // 手动更改高度，不同位置的高度有所不同，模拟瀑布流
        holder.mContent.setHeight(100 + (position % 3) * 30);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public EntityInfo getItem(int position) {
        return mDatas.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public EntityInfo mItem;
        public TextView mTitle;
        public TextView mContent;
        public TextView mTime;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitle = mView.findViewById(R.id.tv_title);
            mContent = mView.findViewById(R.id.tv_content);
            mTime = mView.findViewById(R.id.tv_time);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }

}