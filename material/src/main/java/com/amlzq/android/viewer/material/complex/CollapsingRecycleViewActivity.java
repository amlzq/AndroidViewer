package com.amlzq.android.viewer.material.complex;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.amlzq.android.viewer.common.data.MomentData;
import com.amlzq.android.viewer.common.data.MomentInfo;
import com.amlzq.android.viewer.material.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * AppBarLayout
 * CollapsingToolbarLayout
 * Toolbar
 * RecyclerView
 * FloatingActionButton
 */

public class CollapsingRecycleViewActivity extends AppCompatActivity
        implements SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    Toolbar mToolbar;
    CollapsingToolbarLayout mCollapsingToolbar;
    protected SwipeRefreshLayout mSwipeRefresh;
    protected RecyclerView mRecyclerView;
    ContentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_recycleview);

        mToolbar = findViewById(R.id.toolbar);
        mCollapsingToolbar = findViewById(R.id.collapsing_toolbar);
        mSwipeRefresh = findViewById(R.id.swipe_refresh);
        mRecyclerView = findViewById(R.id.recycler_view);

        setSupportActionBar(mToolbar);

        // 设置进度条的颜色主题，最多能设置四种，加载颜色是循环播放的，只要没有完成刷新就会一直循环，holo_blue_bright>holo_green_light>holo_orange_light>holo_red_light
        mSwipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeRefresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwipeRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwipeRefresh.setSize(SwipeRefreshLayout.LARGE);
        mSwipeRefresh.setOnRefreshListener(this);

        // CollapsingToolbarLayout和RecyclerView联动
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setAdapter(mAdapter = new ContentAdapter(this));
        mAdapter.setItemClickListener(this);
        mAdapter.setItemLongClickListener(this);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        mCollapsingToolbar.setTitle(title);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MomentInfo item = mAdapter.getItem(position);
        Intent intent = CollapsingScrollViewActivity.newIntent(this,
                item.name,
                item.image,
                item.text);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        MomentInfo item = mAdapter.getItem(position);
        Toast.makeText(this, "long click " + item.name, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> mSwipeRefresh.setRefreshing(false), 3000);
    }

    private class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

        private final Context mContext;
        private final List<MomentInfo> mValues;
        private final SimpleDateFormat mFormat;
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
            mValues.addAll(MomentData.ITEMS);
            mFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        }

        @Override
        public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_view, parent, false));
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {
            MomentInfo item = mValues.get(position);

            holder.mTitle.setText(item.name);
            holder.mContent.setText(item.text);
            String date = mFormat.format(new Date(mValues.get(position).time));
            holder.mTime.setText(date);

            Palette.from(BitmapFactory.decodeResource(getResources(), item.image)).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    int defaultColor = ContextCompat.getColor(mContext, R.color.colorPrimary);

                    ((CardView) (holder.mView)).setCardBackgroundColor(palette.getDominantColor(defaultColor));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        holder.mAvatar.setImageTintList(ColorStateList.valueOf(palette.getVibrantColor(defaultColor)));
                        holder.mMore.setImageTintList(ColorStateList.valueOf(palette.getDominantSwatch().getTitleTextColor()));
                    }
                    // 不知为何无效
//                    Drawable drawable = getTintedDrawable(mContext, R.drawable.ic_avatar_black_24dp, Color.RED);
//                    holder.mAvatar.setImageDrawable(drawable);
                    holder.mTitle.setTextColor(palette.getDominantSwatch().getTitleTextColor());
                    holder.mContent.setTextColor(palette.getDominantSwatch().getBodyTextColor());
                    holder.mTime.setTextColor(palette.getDominantSwatch().getBodyTextColor());
                }
            });

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

        /**
         * 获取着色的VectorDrawable
         * 向后兼容
         * https://stackoverflow.com/questions/36731919/drawablecompat-settint-not-working-on-api-19
         * https://stackoverflow.com/questions/37685056/android-support-library-getdrawable-independent-if-vector-or-not
         */
        public Drawable getTintedDrawable(Context cxt, @DrawableRes int drawResId, int tintColor) {
            // Drawable drawable = ContextCompat.getDrawable(cxt, drawableResId); // android.content.res.Resources$NotFoundException
            Drawable drawable = AppCompatResources.getDrawable(cxt, drawResId);
            // ResourcesCompat.getDrawable(context.resources, resId, theme)
            drawable = DrawableCompat.wrap(drawable);
            drawable = drawable.mutate();
            DrawableCompat.setTint(drawable, tintColor);
            return drawable;
        }

        public MomentInfo getItem(int position) {
            return mValues.get(position);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final View mView;
            private final ImageView mAvatar;
            private final ImageView mMore;
            private final TextView mTitle;
            private final TextView mContent;
            private final TextView mTime;

            public ViewHolder(View itemView) {
                super(itemView);
                mView = itemView;
                mAvatar = itemView.findViewById(R.id.avatar);
                mMore = itemView.findViewById(R.id.more);
                mTitle = itemView.findViewById(R.id.title);
                mContent = itemView.findViewById(R.id.content);
                mTime = itemView.findViewById(R.id.time);
            }
        }
    }

}
