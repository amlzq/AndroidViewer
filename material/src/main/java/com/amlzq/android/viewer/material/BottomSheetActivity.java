package com.amlzq.android.viewer.material;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * BottomSheetBehavior使用样例
 */
public class BottomSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

    }

    public void onPopupDialog(View view) {
//        BottomSheetDialogFragment dialogFragment = new BottomSheetDialogFragment();
//        LayoutInflater inflater = dialogFragment.getLayoutInflater();
//        inflater.inflate(R.layout.layout_bottom_sheet_dialog, null, false);
//        dialogFragment.setCancelable(false);
//        dialogFragment.show(getSupportFragmentManager(), "1");

        MyBottomSheetDialogFragment dialogFragment = new MyBottomSheetDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "");
        dialogFragment.setCancelable(true);

        // 事件
        BottomSheetDialog dialog = (BottomSheetDialog) dialogFragment.getDialog();
        if (dialog == null) return;
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // doing something
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                // doing something
            }
        });
    }

    /**
     * 自定义底部工作表
     */
    public static class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_bottom_sheet_dialog, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
//            BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
//            dialog.getSupportActionBar().setIcon(R.drawable.ic_add_black_24dp);

            getView().findViewById(R.id.share).setOnClickListener(v -> {
                Toast toast = Toast.makeText(getContext(), "click Share", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            });
        }

        @Override
        public void onStart() {
            super.onStart();

            BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
            FrameLayout bottomSheet = dialog.getDelegate().findViewById(com.google.android.material.R.id.design_bottom_sheet);

            if (bottomSheet != null) {

                // 改变高度
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomSheet.getLayoutParams();
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 256, getResources().getDisplayMetrics());
                layoutParams.height = height;

                // 获得行为对象
                BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
                // 改变窥视高度
                int peekHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56, getResources().getDisplayMetrics());
                behavior.setPeekHeight(peekHeight);
                // 改变状态
                // 底页有5种状态：
                // STATE_COLLAPSED：底部可见，但仅显示其窥视高度。此状态通常是底表的“静止位置”。窥视高度由开发人员选择，并且应足以指示有更多内容，允许用户触发操作或扩展底页。
                // STATE_EXPANDED：底部可见，其最大高度不可见，也不拖动或沉降（请参见下文）。
                // STATE_DRAGGING：用户正在积极向上或向下拖动底部工作表。
                // STATE_SETTLING：拖动/滑动手势后，底纸会沉降到特定的高度。万一用户操作导致底页隐藏，这将是窥视高度，扩展高度或0。
                // STATE_HIDDEN：底部页面不再可见。
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }

        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }

        @Override
        public void onDismiss(@NonNull DialogInterface dialog) {
            super.onDismiss(dialog);
        }

        @Override
        public void onCancel(@NonNull DialogInterface dialog) {
            super.onCancel(dialog);
        }

    }

}
