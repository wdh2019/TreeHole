package com.hcinteract.treehole.release;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hcinteract.treehole.Data;
import com.hcinteract.treehole.HomeActivity;
import com.hcinteract.treehole.R;
import com.hcinteract.treehole.ReleaseActivity;
import com.hcinteract.treehole.types.home;
import com.hcinteract.treehole.utils.HttpUtil;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class ReleaseContent extends RelativeLayout {
    private Context mContext;
    public ReleaseContent(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.home_release, this);

        EditText editText = findViewById(R.id.edit_home_release);
        EditText creator = findViewById(R.id.edit_home_release_creator);
        // 提交按钮绑定点击事件
        Button submitButton = findViewById(R.id.submit_edit_home_release);
//        submitButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mContext != null) {
//                    String text = editText.getText().toString();
//                    String tCreator = creator.getText().toString();
////                    Toast.makeText(mContext, "提交成功，输入的文字是：" + text + "创建者：" + tCreator, Toast.LENGTH_SHORT).show();
//
//                    HashMap<String, Object> params = new HashMap<>();
//                    params.put("content", text);
//                    params.put("creator", tCreator);
//                    HttpUtil.asyncPost("http://10.0.2.2:8080/createTreeHole", params, new HttpUtil.MyCall() {
//                        @Override
//                        public void succeed(Call call, Response response) throws IOException {
//                            if (response.code() == 200) {
//                                Looper.prepare();
//                                Toast.makeText(mContext, response.message(), Toast.LENGTH_SHORT).show();
//                                Looper.loop();
//                            } else {
//                                Looper.prepare();
//                                Toast.makeText(mContext, response.code() + ":" + response.message(), Toast.LENGTH_SHORT).show();
//                                Looper.loop();
//                            }
//                        }
//
//                        @Override
//                        public void fail(Call call, IOException e) {
//                            e.printStackTrace();
//                        }
//                    });
//                }
//            }
//        });

        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    if(editText.getText().toString().equals("")){
                        Toast.makeText(mContext, "发布内容不能为空哦~" , Toast.LENGTH_SHORT).show();
                    }else if(creator.getText().toString().equals("")){
                        Toast.makeText(mContext, "发布昵称不能为空哦~" , Toast.LENGTH_SHORT).show();
                    }else{
                        int homeId = Data.getHomeListSize();
                        String homeContent = editText.getText().toString();
                        String homeCreator = creator.getText().toString();
                        long homeCreateTime = 20210102;
                        home newhome = new home(homeId,homeContent,homeCreator,homeCreateTime);
                        Data.addHomeList(newhome);



                        Intent intent = new Intent();
                        intent.setClass(mContext, HomeActivity.class);
                        mContext.startActivity(intent);
                        Toast.makeText(mContext, "发布成功,树洞ID为：" + homeId , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
