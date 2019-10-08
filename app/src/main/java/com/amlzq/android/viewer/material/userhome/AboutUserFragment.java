package com.amlzq.android.viewer.material.userhome;

import android.os.Bundle;

import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.R;

/**
 * 用户主页-关于我
 */
public class AboutUserFragment extends MyBaseFragment {
    public static final String TAG = "AboutUserFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AboutUserFragment() {
        // Required empty public constructor
    }

    public static AboutUserFragment newInstance(String param1, String param2) {
        AboutUserFragment fragment = new AboutUserFragment();
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
        return R.layout.fragment_about_user;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);
        setTitle("关于我");
    }
}