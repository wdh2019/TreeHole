package com.hcinteract.treehole.post;

import android.content.Intent;
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
import com.hcinteract.treehole.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView poster;
        private TextView message;
        private TextView id;
        private TextView time;
        private TextView report;

        public ViewHolder(View view) {
            super(view);
            this.poster = view.findViewById(R.id.poster_content_post);
            this.message = view.findViewById(R.id.message_content_post);
            this.id = view.findViewById(R.id.id_content_post);
            this.time = view.findViewById(R.id.time_content_post);
            this.report = view.findViewById(R.id.report_content_post);
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
        // 子项中举报文字的点击事件
        viewHolder.report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posterId = viewHolder.poster.getText().toString();
                Toast.makeText(parent.getContext(), "您已成功举报用户" + posterId, Toast.LENGTH_SHORT).show();
            }
        });
        // 子项整个视图的点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 点击整个子项，跳转到 ReplyActivity
                int position = viewHolder.getLayoutPosition();
                Post post = postList.get(position);
                Intent intent = new Intent(parent.getContext(), ReplyActivity.class);
                intent.putExtra("treeHoleId", 1); // !!, 请用真实的 treeHoleId 替换此处
                intent.putExtra("replyId", post.replyId);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 根据子项数据，填充子项视图
        Post post = postList.get(position);
        holder.poster.setText("[" + post.replier + "]");
        // 在内容中拼接 reReplyId
        String message = post.content;
        if (post.reReplyId != 0) {
            message = "回复#"+ post.reReplyId + ":" + message;
        }
        holder.message.setText(message);
        holder.id.setText(post.replyId + "");
        holder.time.setText(DateUtil.fromNow(new Date(post.replyTime)));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
