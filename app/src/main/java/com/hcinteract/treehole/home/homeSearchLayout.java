package com.hcinteract.treehole.home;

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
import com.hcinteract.treehole.ReleaseActivity;
import com.hcinteract.treehole.utils.HttpUtil;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class homeSearchLayout extends RelativeLayout {
    private Context mContext;

    public homeSearchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.home_search, this);

        Button report = (Button) findViewById(R.id.home_search_button);
        EditText editText = findViewById(R.id.edit_home_search);
        Button release = findViewById(R.id.home_release_button);

        // 搜索功能
        report.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext != null) {
                    Toast.makeText(mContext, "搜索按钮", Toast.LENGTH_SHORT).show();
                    String content = editText.getText().toString();
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("content", content);
                    HttpUtil.asyncPost("http://10.0.2.2:8080/makeReply", params, new HttpUtil.MyCall() {
                        @Override
                        public void succeed(Call call, Response response) throws IOException {
                            if (response.code() == 200) {
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

        // 发布功能
        release.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext != null) {
                    Intent intent = new Intent();
                    intent.setClass(mContext, ReleaseActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }
}
