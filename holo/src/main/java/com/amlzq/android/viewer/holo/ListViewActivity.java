package com.amlzq.android.viewer.holo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

    }

    private class ContentAdapter extends BaseAdapter {

        Context mContext;

        public ContentAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // android.R.layout.simple_list_item_1
            // holder.mTextView.setText("Item " + new DecimalFormat("00").format(position));
            ViewHolder holder = new ViewHolder(LayoutInflater.from(mContext).inflate(android.R.layout.activity_list_item, parent, false));

            return null;
        }

        public class ViewHolder {
            private ImageView mIconView;
            private TextView mTextView;

            public ViewHolder(View itemView) {
                mIconView = (ImageView) itemView.findViewById(android.R.id.icon);
                mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }

}
