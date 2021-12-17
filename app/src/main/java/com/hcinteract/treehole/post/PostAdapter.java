package com.hcinteract.treehole.post;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcinteract.treehole.R;
import com.hcinteract.treehole.ReplyActivity;
import com.hcinteract.treehole.types.Post;

import java.util.ArrayList;
import java.util.Date;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView poster;
        private TextView message;
        private TextView id;
        private TextView time;

        public ViewHolder(View view) {
            super(view);
            this.poster = view.findViewById(R.id.poster_content_post);
            this.message = view.findViewById(R.id.message_content_post);
            this.id = view.findViewById(R.id.id_content_post);
            this.time = view.findViewById(R.id.time_content_post);
        }
    }

    private ArrayList<Post> postList;

    public PostAdapter(ArrayList<Post> postList) {
        super();
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 绑定子项布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_post, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 点击整个子项，跳转到 ReplyActivity
                int position = viewHolder.getLayoutPosition();
                Post post = postList.get(position);
                Intent intent = new Intent(parent.getContext(), ReplyActivity.class);
                intent.putExtra("posterId", post.posterId);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 根据子项数据，填充子项视图
        Post post = postList.get(position);
        holder.poster.setText("[" + post.posterId + "]");
        holder.message.setText(post.content);
        holder.id.setText(post.posterId + "");
        holder.time.setText(new Date(post.postTime).toString());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
