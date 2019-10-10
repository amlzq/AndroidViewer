package com.amlzq.android.viewer.material.userhome;

import android.os.Bundle;

import com.amlzq.android.viewer.MyBaseFragment;
import com.amlzq.android.viewer.R;

/**
 * 用户主页-关于我
 */
public class ProfileBoardFragment extends MyBaseFragment {
    public static final String TAG = "ProfileBoardFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileBoardFragment() {
        // Required empty public constructor
    }

    public static ProfileBoardFragment newInstance(String param1, String param2) {
        ProfileBoardFragment fragment = new ProfileBoardFragment();
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
        return R.layout.fragment_profile_board;
    }

    @Override
    protected void afterCreate(Bundle bundle) {
        super.afterCreate(bundle);
        setTitle("关于我");
    }
}