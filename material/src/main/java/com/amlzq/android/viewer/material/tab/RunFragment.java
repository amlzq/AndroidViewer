package com.amlzq.android.viewer.material.tab;


import android.os.Bundle;
import android.view.View;

import com.amlzq.android.ApplicationConstant;
import com.amlzq.android.util.ActivityUtil;
import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.material.ActionAppCompatActivity;
import com.amlzq.android.viewer.material.R;

/**
 * 跑步
 */
public class RunFragment extends MyBaseFragment {
    public static final String TAG = "RunFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public RunFragment() {
        // Required empty public constructor
    }

    public static RunFragment newInstance(String param1, String param2) {
        RunFragment fragment = new RunFragment();
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
        return R.layout.fragment_run;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);
        findViewById(R.id.btn_action).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.btn_action) {
            mInteraction.clear();
            mInteraction.putString(ApplicationConstant.TARGET_VIEW, ActionAppCompatActivity.TAG);
            mInteraction.putString(ActivityUtil.FRAGMENT_TAG, DetailFragment.TAG);
            mListener.onFragmentInteraction(mInteraction);
        }
    }

}
