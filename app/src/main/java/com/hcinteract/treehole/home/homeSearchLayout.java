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
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcinteract.treehole.Data;
import com.hcinteract.treehole.R;
import com.hcinteract.treehole.ReleaseActivity;
import com.hcinteract.treehole.SearchResultActivity;
import com.hcinteract.treehole.types.home;
import com.hcinteract.treehole.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class homeSearchLayout extends RelativeLayout {
    private Context mContext;
    private ArrayList<home> homeList = new ArrayList<home>();

    public homeSearchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.home_search, this);

        Button report = (Button) findViewById(R.id.home_search_button);
        EditText editText = findViewById(R.id.edit_home_search);
        Button release = findViewById(R.id.home_release_button);
        // 搜索功能假数据版本
        report.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    String searchContent = editText.getText().toString();

                    // 判断是否为数字ID
                    if (searchContent.replace("-", "").matches("^[0-9]+$")) {
                        Data.setSearchId(searchContent);
                        Intent intent = new Intent();
                        intent.setClass(mContext, SearchResultActivity.class);
                        mContext.startActivity(intent);
                    }else {
                        Toast.makeText(mContext, "请输出数字ID哦~" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        // 搜索功能
//        report.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mContext != null) {
//                    String content = editText.getText().toString();
////                    Toast.makeText(mContext, "搜索内容为：" + content, Toast.LENGTH_SHORT).show();
//
//                    HashMap<String, Object> params = new HashMap<>();
//                    params.put("treeHoleId", Integer.valueOf(content));
//                    HttpUtil.asyncPost("http://10.0.2.2:8080/searchTreeHoles", params, new HttpUtil.MyCall() {
//                        @Override
//                        public void succeed(Call call, Response response) throws IOException {
//                            if (response.code() == 200) {
//                                String str = response.body().string();
//                                try {
//                                    // replies 是一个数组
//                                    JSONArray jsonArray = new JSONArray(str);
//                                    for (int i = 0; i < jsonArray.length(); i++) {
//                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                        int treeHoleId = jsonObject.getInt("treeHoleId");
//                                        String content = jsonObject.getString("content");
//                                        String creator = jsonObject.getString("creator");
//                                        long createTime = jsonObject.getLong("createTime");
//                                        homeList.add(new home(treeHoleId, content,creator,createTime));
//                                    }
//                                    // 等接口请求到数据后，再绑定视图
//                                    RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_home);
//                                    LinearLayoutManager layoutManager = new LinearLayoutManager(mContext.getApplicationContext());
//                                    recyclerView.setLayoutManager(layoutManager);
//                                    homeAdapter adapter = new homeAdapter(homeList);
//                                    recyclerView.setAdapter(adapter);
//
//                                    if (homeList.size() != 0) {
//                                        TextView nothing = findViewById(R.id.nothing_content_post);
//                                        nothing.setText("已经到底了，没有更多了~");
//                                    }
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
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
