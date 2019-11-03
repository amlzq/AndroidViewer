package com.amlzq.android.viewer.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity
        implements View.OnClickListener {

    EditText mFeedback;
    EditText mContact;

    public static Intent newIntent(Context context, String subject) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        intent.putExtra("params", subject);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mFeedback = findViewById(R.id.feedback);
        mContact = findViewById(R.id.contact);
        findViewById(R.id.send).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send) {
            if (TextUtils.isEmpty(mFeedback.getText().toString().trim())) {
                Toast.makeText(v.getContext(), "请输入反馈内容", Toast.LENGTH_SHORT).show();
            }
            // 发送邮件
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("plain/text");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"lzqjiujiang@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, getIntent().getStringExtra("params"));
            i.putExtra(Intent.EXTRA_TEXT, mFeedback.getText().toString().trim());
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(Intent.createChooser(i, "请选择邮箱客户端应用程序"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(v.getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
