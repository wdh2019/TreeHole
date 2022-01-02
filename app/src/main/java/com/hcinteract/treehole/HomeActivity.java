package com.hcinteract.treehole;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcinteract.treehole.home.homeAdapter;
import com.hcinteract.treehole.post.PostAdapter;
import com.hcinteract.treehole.types.Post;
import com.hcinteract.treehole.types.home;
import com.hcinteract.treehole.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {
//    private ArrayList<home> homeList = new ArrayList<home>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 如果还没有初始化的话
        if(!Data.getIsInit()){
            initHome();
            Data.finishInit();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter adapter = new homeAdapter(Data.getHomeList());
        recyclerView.setAdapter(adapter);
    }



    private void initHome() {
//        HttpUtil.asyncGet("http://10.0.2.2:8080/getTreeHoles", new HttpUtil.MyCall() {
//            @Override
//            public void succeed(Call call, Response response) throws IOException {
//                // 接口有返回
//                if (response.code() == 200) {
////                    homeList = response.data;
//
//                    String str = response.body().string();
//                    try {
//                        // replies 是一个数组
//                        JSONArray jsonArray = new JSONArray(str);
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject jsonObject = jsonArray.getJSONObject(i);
//                            int treeHoleId = jsonObject.getInt("treeHoleId");
//                            String content = jsonObject.getString("content");
//                            String creator = jsonObject.getString("creator");
//                            long createTime = jsonObject.getLong("createTime");
//                            homeList.add(new home(treeHoleId, content,creator,createTime));
//                        }
//                        // 等接口请求到数据后，再绑定视图
//                        RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_home);
//                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//                        recyclerView.setLayoutManager(layoutManager);
//                        homeAdapter adapter = new homeAdapter(homeList);
//                        recyclerView.setAdapter(adapter);
//                        // 如果有 posts，修改 nothing_content_post 中的文字
//                        if (homeList.size() != 0) {
//                            TextView nothing = findViewById(R.id.nothing_content_post);
//                            nothing.setText("已经到底了，没有更多了~");
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void fail(Call call, IOException e) {
//                e.printStackTrace();
//            }
//        });

        for (int i = 0; i < 20 ; i++) {
            home newhome = new home(i, "这里是测试数据"+i ,"测试创建者"  + i,11);
//            homeList.add(new home(i, "这里是测试数据"+i ,"测试创建者"  + i,11));
            Data.addHomeList(newhome);
        }
    }

}
