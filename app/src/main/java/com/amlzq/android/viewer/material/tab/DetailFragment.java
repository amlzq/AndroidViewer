package com.amlzq.android.viewer.material.tab;


import android.os.Bundle;

import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.R;

/**
 * 详情页
 */
public class DetailFragment extends MyBaseFragment {
    public static final String TAG = "DetailFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);
        setActivityTitle(getTitle());
    }

}
