package com.amlzq.android.viewer.platform;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * PopupWindow样例
 */
public class PopupWindowDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_demo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void showOptionsPopup(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View contentView = inflater.inflate(R.layout.popup_options, null);
        PopupWindow popup = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popup.showAsDropDown(view);
        // 背景变暗
        final WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f; // 代表透明程度，范围为0 - 1.0f
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
        popup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                lp.alpha = 1.0f;
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
            }
        });
        contentView.findViewById(R.id.start_group_chat).setOnClickListener(v -> {
            Toast.makeText(this, "click start_group_chat", Toast.LENGTH_SHORT).show();
        });
        contentView.findViewById(R.id.add_friend).setOnClickListener(v -> {
            Toast.makeText(this, "click add_friend", Toast.LENGTH_SHORT).show();
        });
        contentView.findViewById(R.id.scan_code).setOnClickListener(v -> {
            Toast.makeText(this, "click scan_code", Toast.LENGTH_SHORT).show();
        });
        contentView.findViewById(R.id.receive_payment).setOnClickListener(v -> {
            Toast.makeText(this, "click receive_payment", Toast.LENGTH_SHORT).show();
        });
    }

    public void showListPopup(View view) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add("Item: " + i);
        }
        LayoutInflater inflater = LayoutInflater.from(this);
        View contentView = inflater.inflate(R.layout.popup_list, null);
        int height; // 设置最大高度
        if (items.size() > 5) {
            height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 256, getResources().getDisplayMetrics());
        } else {
            height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        PopupWindow popup = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        ListView listView = contentView.findViewById(R.id.list_view);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) listView.getLayoutParams();
        params.height = height;
        ContentAdapter adapter = new ContentAdapter(this, items);
        listView.setAdapter(adapter);
        popup.showAtLocation(view, Gravity.CENTER, 0, 0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "click item: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ContentAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;
        private List<String> mItems;


        public ContentAdapter(Context context, List<String> items) {
            this.mContext = context;
            this.mItems = items;
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public String getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                mInflater = LayoutInflater.from(convertView.getContext());
                convertView = mInflater.inflate(android.R.layout.activity_list_item, parent, false);
            } else {

            }
            return convertView;
        }

        private class ViewHolder {
            private View mView;
            private ImageView mIcon;
            private TextView mContent;

            ViewHolder() {

            }
        }

    }

}
