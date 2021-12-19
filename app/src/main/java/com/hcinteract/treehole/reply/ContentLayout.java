package com.hcinteract.treehole.reply;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hcinteract.treehole.R;

public class ContentLayout extends RelativeLayout {
    private Context mContext;
    public ContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.content_reply, this);

        Activity activity = (Activity)mContext;
        Intent intent = activity.getIntent();
        int treeHoleId = intent.getIntExtra("treeHoleId", 1);
        int replyId = intent.getIntExtra("replyId", 0);

        EditText editText = findViewById(R.id.edit_content_reply);
        // 提交按钮绑定点击事件
        Button submitButton = findViewById(R.id.submit_content_reply);
        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    String content = editText.getText().toString();
                    String tip = "提交成功，" + " treeHoleId:" + treeHoleId + " replyId:" + replyId + " content: " + content;
                    Toast.makeText(mContext, tip, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
