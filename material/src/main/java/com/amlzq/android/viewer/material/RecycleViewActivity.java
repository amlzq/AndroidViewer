package com.amlzq.android.viewer.material;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.amlzq.android.viewer.data.EntityInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView+CardView样例
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
        private List<EntityInfo> mValues = new ArrayList<>();

        public CardListAdapter(Context context, List<EntityInfo> items) {
            mContext = context;
            mValues.addAll(items);
        }

        @NonNull
        @Override
        public CardListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CardListAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_view, parent, false));
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
            return mValues.size();
        }

        public EntityInfo getItem(int position) {
            return mValues.get(position);
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
                mTitle = mView.findViewById(R.id.title);
                mContent = mView.findViewById(R.id.content);
                mTime = mView.findViewById(R.id.time);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mItem.toString() + "'";
            }
        }
    }

}