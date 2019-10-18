package com.amlzq.android.viewer.platform;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * 对话框演示样例
 */
public class DialogDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);
    }

    void showToastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * android.app.AlertDialog
     *
     * @param view
     */
    public void onAlertDialog(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(R.string.prompt);
        builder.setIcon(android.R.drawable.sym_def_app_icon);
        builder.setMessage("this is android.app.AlertDialog");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Positive Button", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).setNeutralButton(R.string.jump_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 中性
                Toast.makeText(getBaseContext(), "Neutral Button", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Negative Button", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void onListDialog(View view) {
        final String items[] = new String[]{"item1", "item2", "item3",
                "item4", "item5", "item6"};

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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

    public void onDatePickerDialog(View view) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 因为monthOfYear会比实际月份少一月所以这边要加1
                showToastShort(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void onTimePickerDialog(View view) {
        final Calendar calendar = Calendar.getInstance(); // 日历对象
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        final TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                showToastShort(" " + hourOfDay + ":" + minute);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    public void onSpinnerProgressDialog(View view) {
        // API 26 Deprecated
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.prompt);
        progressDialog.setMessage("这是一个圆形进度条");
        // 样式有两种，一种是圆形不明确状态，一种是水平进度条状态
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 圆形不明确状态
        /// 设置可点击的按钮，最多有三个(默认情况下)
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        progressDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "中立",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        progressDialog.show();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    // cancel和dismiss方法本质都是一样的，都是从屏幕中删除Dialog,唯一的区别是
                    // 调用cancel方法会回调DialogInterface.OnCancelListener如果注册的话,dismiss方法不会回掉
                    progressDialog.cancel();
                    // dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onHorizontalProgressDialog(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(android.R.drawable.sym_def_app_icon);
        progressDialog.setTitle(R.string.prompt);
        progressDialog.setMessage("这是一个水平进度条");
        // 样式有两种，一种是圆形不明确状态，一种是水平进度条状态
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 水平进度条状态
        progressDialog.setMax(100);
        /// 设置可点击的按钮，最多有三个(默认情况下)
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        progressDialog.show();
        new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(200);
                        // 更新进度条的进度,可以在子线程中更新进度条进度
                        progressDialog.incrementProgressBy(1);
                        // dialog.incrementSecondaryProgressBy(10)//二级进度条更新方式
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 在进度条走完时删除Dialog
                progressDialog.dismiss();
            }
        }).start();
    }

}
