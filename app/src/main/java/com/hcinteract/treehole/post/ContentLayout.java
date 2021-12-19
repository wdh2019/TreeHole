package com.hcinteract.treehole.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.hcinteract.treehole.R;

public class ContentLayout extends RelativeLayout {
    private Context mContext;

    public ContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.content_post, this);
    }
}
