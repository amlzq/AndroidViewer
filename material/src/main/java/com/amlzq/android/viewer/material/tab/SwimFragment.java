package com.amlzq.android.viewer.material.tab;


import android.os.Bundle;

import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.material.R;

/**
 * 游泳
 */
public class SwimFragment extends MyBaseFragment {
    private static final String TAG = "SwimFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public SwimFragment() {
        // Required empty public constructor
    }

    public static SwimFragment newInstance(String param1, String param2) {
        SwimFragment fragment = new SwimFragment();
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
        return R.layout.fragment_swim;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);
    }

}
