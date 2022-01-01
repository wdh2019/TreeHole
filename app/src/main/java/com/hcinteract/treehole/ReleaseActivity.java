package com.hcinteract.treehole;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ReleaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        Intent intent = getIntent();
//        int posterId = intent.getIntExtra("posterId", -1);
//        TextView title = findViewById(R.id.title_header_reply);
//        title.setText("回复#" + posterId);
    }
}