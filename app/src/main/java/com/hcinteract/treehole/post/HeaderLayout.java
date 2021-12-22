package com.hcinteract.treehole.post;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hcinteract.treehole.R;
import com.hcinteract.treehole.ReplyActivity;

public class HeaderLayout extends RelativeLayout {
    private Context mContext;

    public HeaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.header_post, this);

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
                    // replyId 为0，表示创建新 post，而非回复别人
                    Intent intent = new Intent(mContext, ReplyActivity.class);
                    intent.putExtra("treeHoleId", 1); // !!, 请用真实的 treeHoleId 替换此处
                    intent.putExtra("replyId", 0);
                    mContext.startActivity(intent);
                }
            }
        });
    }
}
