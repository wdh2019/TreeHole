package com.hcinteract.treehole;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcinteract.treehole.home.homeAdapter;
import com.hcinteract.treehole.types.home;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<home> homeList = new ArrayList<home>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initPosts();

        RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter adapter = new homeAdapter(homeList);
        recyclerView.setAdapter(adapter);
    }



    private void initPosts() {

//        HttpUtil.asyncGet("http://10.0.2.2:8080/getTreeHoles", new HttpUtil.MyCall() {
//            @Override
//            public void succeed(Call call, Response response) throws IOException {
//                // 接口有返回
//                if (response.code() == 200) {
//                    homeList = response.list;
//                }
//            }
//
//            @Override
//            public void fail(Call call, IOException e) {
//                // 有错误
//                e.printStackTrace();
//            }
//        });

        for (int i = 0; i < 20 ; i++) {
            homeList.add(new home("标题" + i, "dr", "2021-12-18", "这里是一段介绍",1,1));
        }
    }

}
