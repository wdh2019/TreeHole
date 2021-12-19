package com.hcinteract.treehole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hcinteract.treehole.post.PostAdapter;
import com.hcinteract.treehole.types.Post;

import java.util.ArrayList;
import java.util.Date;

public class PostActivity extends AppCompatActivity {
    private ArrayList<Post> postList = new ArrayList<Post>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        initPosts();

        RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_post);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PostAdapter adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);
    }

    // 获取 一个 treehole 下的所有 posts
    private void initPosts() {
        for (int i = 0; i < 20 ; i++) {
            postList.add(new Post(i, 1, 0, "wang", "这是第" + i + "个post", new Date().getTime()));
        }
    }
}