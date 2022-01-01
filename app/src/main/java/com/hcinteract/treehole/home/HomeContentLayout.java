package com.hcinteract.treehole.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.hcinteract.treehole.R;

public class HomeContentLayout extends RelativeLayout {
    private Context mContext;


    public HomeContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.home_content, this);
    }
}
