package com.amlzq.android.viewer.material.userhome;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.amlzq.android.viewer.entity.EntityInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户动态列表适配器
 */
public class MomentListAdapter extends RecyclerView.Adapter<MomentListAdapter.ViewHolder> {

    private List<EntityInfo> mMoments = new ArrayList<>();

    public MomentListAdapter(List<EntityInfo> datas) {
        mMoments.addAll(datas);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.mView.setTag(holder);
//        holder.mItem = item;

//        holder.mNickName.setText(item.getUserNicknameWrapper());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //        public final ImageView mAvatar;
//        public final TextView mNickName;
        public EntityInfo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mAvatar = (ImageView) view.findViewById(R.id.img_avatar);
//            mNickName = (TextView) view.findViewById(R.id.tv_nickname);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }

}