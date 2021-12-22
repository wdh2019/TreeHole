package com.hcinteract.treehole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import com.hcinteract.treehole.post.PostAdapter;
import com.hcinteract.treehole.types.Post;
import com.hcinteract.treehole.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class PostActivity extends AppCompatActivity {
    private ArrayList<Post> postList = new ArrayList<Post>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        // 获取 MainActivity 发来的 intent，并获取 intent 上携带的 treeHoleId
        Intent intent = getIntent();
        int treeHoleId = intent.getIntExtra("treeHoleId", 1);
        initPosts(treeHoleId);
    }

    // 获取 一个 treehole 下的所有 posts
    private void initPosts(int treeHoleId) {
        // 请求接口数据
        // url: http://localhost:8080/getReplies?treeHoleId=xxx  method: get
        HttpUtil.asyncGet("http://10.0.2.2:8080/getReplies?treeHoleId=" + treeHoleId, new HttpUtil.MyCall() {
            @Override
            public void succeed(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    String str = response.body().string();
                    try {
                        // replies 是一个数组
                        JSONArray jsonArray = new JSONArray(str);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int replyId = jsonObject.getInt("replyId");
                            int treeHoleId = jsonObject.getInt("treeHoleId");
                            int reReplyId = jsonObject.getInt("reReplyId");
                            String replier = jsonObject.getString("replier");
                            String content = jsonObject.getString("content");
                            long replyTime = jsonObject.getLong("replyTime");
                            postList.add(new Post(replyId, treeHoleId, reReplyId, replier, content, replyTime));
                        }
                        // 等接口请求到数据后，再绑定视图
                        RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_post);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        PostAdapter adapter = new PostAdapter(postList);
                        recyclerView.setAdapter(adapter);
                        // 如果有 posts，修改 nothing_content_post 中的文字
                        if (postList.size() != 0) {
                            TextView nothing = findViewById(R.id.nothing_content_post);
                            nothing.setText("已经到底了，没有更多了~");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Looper.prepare();
                    Toast.makeText(getApplicationContext(), response.code() + ":" + response.message(), Toast.LENGTH_SHORT).show();
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