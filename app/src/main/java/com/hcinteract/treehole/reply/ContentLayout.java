package com.hcinteract.treehole.reply;

import android.app.Activity;
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

import com.hcinteract.treehole.R;
import com.hcinteract.treehole.utils.HttpUtil;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class ContentLayout extends RelativeLayout {
    private Context mContext;
    public ContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.content_reply, this);

        Activity activity = (Activity)mContext;
        Intent intent = activity.getIntent();
        int treeHoleId = intent.getIntExtra("treeHoleId", 1);
        int replyId = intent.getIntExtra("replyId", 0);

        EditText editName = findViewById(R.id.edit_name_reply);
        EditText editText = findViewById(R.id.edit_content_reply);
        // 提交按钮绑定点击事件
        Button submitButton = findViewById(R.id.submit_content_reply);
        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    String name = editText.getText().toString();
                    String content = editText.getText().toString();
                    if (name.length() == 0) {
                        Toast.makeText(mContext, "请填写你的昵称", Toast.LENGTH_SHORT);
                        return;
                    }
                    if (content.length() == 0) {
                        Toast.makeText(mContext, "请填写发帖内容", Toast.LENGTH_SHORT);
                        return;
                    }
                    // 发送数据给接口
                    // url:localhost:8080/makeReply, method: post
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("treeHoleId", treeHoleId);
                    params.put("content", content);
                    params.put("reReplyId", replyId);
                    params.put("replier", name);
                    // android 模拟器会把 localhost 当做本身，用 10.0.2.2 的 ip 替代
                    // https://blog.csdn.net/xulianboblog/article/details/51335361
                    HttpUtil.asyncPost("http://10.0.2.2:8080/makeReply", params, new HttpUtil.MyCall() {
                        @Override
                        public void succeed(Call call, Response response) throws IOException {
                            if (response.code() == 200) {
                                // android 子线程不允许直接 Toast.makeText，前后要加上 Looper.prepare() 和 Looper.loop()
                                // https://www.cnblogs.com/hzauxx/p/11928951.html
                                Looper.prepare();
                                Toast.makeText(mContext, response.message(), Toast.LENGTH_SHORT).show();
                                Looper.loop();
                            } else {
                                Looper.prepare();
                                Toast.makeText(mContext, response.code() + ":" + response.message(), Toast.LENGTH_SHORT).show();
                                Looper.loop();
                            }
                        }

                        @Override
                        public void fail(Call call, IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
    }
}
