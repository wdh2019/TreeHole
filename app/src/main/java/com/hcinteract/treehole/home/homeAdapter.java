package com.hcinteract.treehole.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcinteract.treehole.PostActivity;
import com.hcinteract.treehole.R;
import com.hcinteract.treehole.types.home;

import java.util.ArrayList;

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.ViewHolder> {
   protected class ViewHolder extends RecyclerView.ViewHolder {
       private TextView title;
       private TextView user;
       private TextView time;
       private TextView intro;

       private TextView agrees;
       private TextView comments;

       public ViewHolder(View view) {
           super(view);
           this.title = view.findViewById(R.id.home_content_title);
           this.user = view.findViewById(R.id.home_content_user);
           this.time = view.findViewById(R.id.home_content_time);
           this.intro = view.findViewById(R.id.home_content_intro);
       }
   }

   private ArrayList<home> homeList;

   public homeAdapter(ArrayList<home> homeList) {
       super();
       this.homeList = homeList;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // 绑定子项布局
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content, parent, false);
       ViewHolder viewHolder = new ViewHolder(view);

       viewHolder.intro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//                Toast.makeText(parent.getContext(), "您已成功举报用户" , Toast.LENGTH_SHORT).show();
               int position = viewHolder.getLayoutPosition();
               Intent intent = new Intent(parent.getContext(), PostActivity.class);
               parent.getContext().startActivity(intent);
           }
       });

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 点击整个子项，跳转到 ReplyActivity
//                int position = viewHolder.getLayoutPosition();
//                home home = homeList.get(position);
//                Intent intent = new Intent(parent.getContext(), HomeActivity.class);
////                intent.putExtra("homeId", home.homeId);
//                parent.getContext().startActivity(intent);
//            }
//        });
       return viewHolder;
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // 根据子项数据，填充子项视图
       home home = homeList.get(position);
       holder.title.setText(home.title);
       holder.user.setText(home.user);
       holder.intro.setText(home.intro);
       holder.time.setText(home.time);
//        holder.agrees.setText(home.agrees);
//        holder.comments.setText(home.comments);
   }

   @Override
   public int getItemCount() {
       return homeList.size();
   }
}
