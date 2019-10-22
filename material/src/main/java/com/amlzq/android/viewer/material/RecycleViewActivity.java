package com.amlzq.android.viewer.material;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amlzq.android.viewer.data.EntityInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView样例
 */
public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CardListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        List<EntityInfo> entities = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            EntityInfo EntityInfo = new EntityInfo();
            EntityInfo.setId("" + i);
            EntityInfo.setContent("内容" + i);
            entities.add(EntityInfo);
        }
        mRecyclerView.setAdapter(mAdapter = new CardListAdapter(this, entities));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycle_view_layout_manager, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_linear) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mAdapter.notifyDataSetChanged();
        } else if (id == R.id.action_grid) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            mAdapter.notifyDataSetChanged();
        } else if (id == R.id.action_staggered_grid) {
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

        private Context mContext;
        private List<EntityInfo> mDatas = new ArrayList<>();

        public CardListAdapter(Context context, List<EntityInfo> datas) {
            mContext = context;
            mDatas.addAll(datas);
        }

        @NonNull
        @Override
        public CardListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CardListAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CardListAdapter.ViewHolder holder, int position) {
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

}