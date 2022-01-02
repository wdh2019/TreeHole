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

public class SearchResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_activity_search_result);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter adapter = new homeAdapter(Data.getHomeListById());
        recyclerView.setAdapter(adapter);

    }

}
