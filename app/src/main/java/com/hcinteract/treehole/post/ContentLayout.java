package com.hcinteract.treehole.post;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hcinteract.treehole.R;
import com.hcinteract.treehole.types.Post;

public class ContentLayout extends RelativeLayout {
    private Context mContext;

    public ContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.content_post, this);

        TextView report = findViewById(R.id.report_content_post);
        report.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext != null) {
                    Toast.makeText(mContext, "已收到您的举报", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
