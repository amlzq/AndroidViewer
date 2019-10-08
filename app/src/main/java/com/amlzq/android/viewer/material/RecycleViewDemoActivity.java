package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.data.domain.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView样例
 */
public class RecycleViewDemoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CardListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        List<Entity> entities = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Entity entity = new Entity();
            entity.setId("" + i);
            entity.setContent("内容" + i);
            entities.add(entity);
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
        switch (item.getItemId()) {
            case R.id.action_linear:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                mAdapter.notifyDataSetChanged();
                break;

            case R.id.action_grid:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                mAdapter.notifyDataSetChanged();
                break;

            case R.id.action_staggered_grid:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
