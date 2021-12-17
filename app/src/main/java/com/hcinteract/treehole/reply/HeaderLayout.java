package com.hcinteract.treehole.reply;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hcinteract.treehole.R;

public class HeaderLayout extends RelativeLayout {
    private Context mContext;

    public HeaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.header_reply, this);

        // back按钮绑定点击事件
        ImageView back = (ImageView)findViewById(R.id.back_header_reply);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    ((Activity)mContext).finish();
                }
            }
        });

        // 图片按钮绑定点击事件
        ImageView pic = (ImageView)findViewById(R.id.pic_header_reply);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    Toast.makeText(mContext, "你按下了这个按钮，但你不知道它有什么用", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
