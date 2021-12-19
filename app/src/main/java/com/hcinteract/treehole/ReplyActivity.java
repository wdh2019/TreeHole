package com.hcinteract.treehole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        // 接收 PostActivity 传来的 replyId 和 treeHoleId
        Intent intent = getIntent();
        int replyId = intent.getIntExtra("replyId", 0);
        TextView title = findViewById(R.id.title_header_reply);
        title.setText("回复#" + replyId);
    }
}