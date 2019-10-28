package com.amlzq.android.viewer.material;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class FlexboxRecycleViewActivity extends AppCompatActivity
        implements SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecyclerView;
    private ContentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSwipeRefresh = new SwipeRefreshLayout(this);
        // 设置进度条的颜色主题，最多能设置四种，加载颜色是循环播放的，只要没有完成刷新就会一直循环，holo_blue_bright>holo_green_light>holo_orange_light>holo_red_light
        mSwipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeRefresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwipeRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwipeRefresh.setSize(SwipeRefreshLayout.LARGE);
        mSwipeRefresh.setOnRefreshListener(this);

        mRecyclerView = new RecyclerView(this);
        // CollapsingToolbarLayout和RecyclerView联动
        mRecyclerView.setNestedScrollingEnabled(true);
        FlexboxLayoutManager manager = new FlexboxLayoutManager(mRecyclerView.getContext());
        manager.setFlexDirection(FlexDirection.COLUMN);
        manager.setJustifyContent(JustifyContent.FLEX_END);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter = new ContentAdapter(this));
        mAdapter.setItemClickListener(this);
        mAdapter.setItemLongClickListener(this);

        mSwipeRefresh.addView(mRecyclerView);
        setContentView(mSwipeRefresh);

        // 制造数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String string = "Item: " + i;
            list.add(string);
        }
        mAdapter.setNewData(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "item click: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "item long click: " + position, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> mSwipeRefresh.setRefreshing(false), 3000);
    }

    private class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

        private final Context mContext;
        private final List<String> mValues;
        private AdapterView.OnItemClickListener mItemClickListener;
        private AdapterView.OnItemLongClickListener mItemLongClickListener;

        public void setItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
            this.mItemClickListener = itemClickListener;
        }

        public void setItemLongClickListener(AdapterView.OnItemLongClickListener itemLongClickListener) {
            this.mItemLongClickListener = itemLongClickListener;
        }

        public ContentAdapter(Context context) {
            mContext = context;
            mValues = new ArrayList<>();
        }

        public void setNewData(List<String> items) {
            mValues.clear();
            mValues.addAll(items);
        }

        @Override
        public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(android.R.layout.activity_list_item,
                    parent, false));
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {
            String item = mValues.get(position);

            holder.mIcon.setImageResource(android.R.drawable.sym_def_app_icon);
            holder.mContent.setText(item);

            holder.mView.setOnClickListener(v -> {
                mItemClickListener.onItemClick(null,
                        v,
                        holder.getAdapterPosition(),
                        holder.getItemId());
            });
            holder.mView.setOnLongClickListener(v -> {
                mItemLongClickListener.onItemLongClick(null,
                        v,
                        holder.getAdapterPosition(),
                        holder.getItemId());
                return true;
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final View mView;
            private final ImageView mIcon;
            private final TextView mContent;

            public ViewHolder(View itemView) {
                super(itemView);
                mView = itemView;
                mIcon = itemView.findViewById(android.R.id.icon);
                mContent = itemView.findViewById(android.R.id.text1);
            }
        }
    }

}
