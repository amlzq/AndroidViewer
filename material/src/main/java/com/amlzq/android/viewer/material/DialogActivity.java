package com.amlzq.android.viewer.material;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 对话框演示样例
 * 材料设计
 */
public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_material);
    }

    void showToastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * android.support.v7.app.AlertDialog V7包中的对话框，向后适配材料设计样式
     *
     * @param view
     */
    public void onAlertDialog(View view) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(R.string.prompt);
        builder.setIcon(android.R.drawable.sym_def_app_icon);
        builder.setMessage("this is android.support.v7.app.AlertDialog");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Positive Button");
                dialog.dismiss();
            }
        }).setNeutralButton(R.string.jump_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Neutral Button");
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Negative Button");
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void onListDialog(View view) {
        final String items[] = new String[]{"item1", "item2", "item3",
                "item4", "item5", "item6"};

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(R.string.prompt);
        builder.setIcon(android.R.drawable.sym_def_app_icon);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort(items[which]);
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Positive Button");
                dialog.dismiss();
            }
        }).setNeutralButton(R.string.jump_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Neutral Button");
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Negative Button");
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void onSingleChoiceDialog(View view) {
        final String items[] = new String[]{"radioButton1", "radioButton2", "radioButton3",
                "radioButton4", "radioButton5", "radioButton6"};

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(R.string.prompt);
        builder.setIcon(android.R.drawable.sym_def_app_icon);
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort(items[which]);
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Positive Button");
                dialog.dismiss();
            }
        }).setNeutralButton(R.string.jump_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Neutral Button");
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Negative Button");
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void onMultiChoiceDialog(View view) {
        final String items[] = new String[]{"radioButton1", "radioButton2", "radioButton3",
                "radioButton4", "radioButton5", "radioButton6"};
        final boolean isChecks[] = new boolean[]{false, true, true, false, false, false};

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle(R.string.prompt);
        builder.setIcon(android.R.drawable.sym_def_app_icon);
        builder.setMultiChoiceItems(items, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                showToastShort(items[which]);
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Positive Button");
                dialog.dismiss();
            }
        }).setNeutralButton(R.string.jump_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Neutral Button");
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Negative Button");
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void onCustomContentDialog(View view) {
        final EditText content = new EditText(this);
        final TextView title = new TextView(this);
        title.setText("this is custom title");
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setCustomTitle(title);
        builder.setIcon(android.R.drawable.sym_def_app_icon);
        builder.setView(content);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Positive Button");
                dialog.dismiss();
            }
        }).setNeutralButton(R.string.jump_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Neutral Button");
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToastShort("Negative Button");
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
