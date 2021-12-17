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
        Intent intent = getIntent();
        int posterId = intent.getIntExtra("posterId", -1);
        TextView title = findViewById(R.id.title_header_reply);
        title.setText("回复#" + posterId);
    }
}