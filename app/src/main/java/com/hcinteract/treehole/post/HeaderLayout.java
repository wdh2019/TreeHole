package com.hcinteract.treehole.post;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hcinteract.treehole.R;
import com.hcinteract.treehole.ReplyActivity;

public class HeaderLayout extends RelativeLayout {
    private Context mContext;

    public HeaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.header_post, this);

        Activity activity = (Activity) mContext;
        Intent intent = activity.getIntent();
        int treeHoleId = intent.getIntExtra("treeHoleId",1);
        String content = intent.getStringExtra("content");

        // title
        TextView title = findViewById(R.id.title_header_reply);
        if ((content != null) && (content.length() > 0)) {
            title.setText(content);
        } else {
            title.setText("树洞#" + treeHoleId);
        }

        // back按钮绑定点击事件
        ImageView back = (ImageView)findViewById(R.id.back_header_post);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    ((Activity)mContext).finish();
                }
            }
        });

        // 图片按钮绑定点击事件
        ImageView pic = (ImageView)findViewById(R.id.add_header_post);
        pic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    // postActivity 接收到的intent
                    Activity parent = (Activity)mContext;
                    Intent receivedIntent = parent.getIntent();
                    int treeHoleId  = receivedIntent.getIntExtra("treeHoleId",1);

                    Intent intent = new Intent(mContext, ReplyActivity.class);
                    intent.putExtra("treeHoleId", treeHoleId); // !!, 请用真实的 treeHoleId 替换此处
                    // replyId 为0，表示创建新 post，而非回复别人
                    intent.putExtra("replyId", 0);
                    mContext.startActivity(intent);
                }
            }
        });
    }
}
