package com.hcinteract.treehole.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcinteract.treehole.PostActivity;
import com.hcinteract.treehole.R;
import com.hcinteract.treehole.types.home;

import java.util.ArrayList;

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.ViewHolder> {
   protected class ViewHolder extends RecyclerView.ViewHolder {

       private TextView treeHoleId;
       private TextView content;
       private TextView creator;
       private TextView createTime;

       private TextView agree;
       private TextView share;

       public ViewHolder(View view) {
           super(view);
           this.treeHoleId = view.findViewById(R.id.home_content_treeHoleId);
           this.content = view.findViewById(R.id.home_content_content);
           this.createTime = view.findViewById(R.id.home_content_createTime);
           this.creator = view.findViewById(R.id.home_content_creator);

           this.agree = view.findViewById(R.id.home_agree);
           this.share = view.findViewById(R.id.home_share);

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
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content, parent, false);
       ViewHolder viewHolder = new ViewHolder(view);

       viewHolder.share.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(parent.getContext(), "分享功能为保留功能哦~" , Toast.LENGTH_SHORT).show();
           }
       });

       viewHolder.agree.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(parent.getContext(), "点赞功能为保留功能哦~" , Toast.LENGTH_SHORT).show();
           }
       });

       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(parent.getContext(), PostActivity.class);
               String treeHoleIdStr = viewHolder.treeHoleId.getText().toString();
               int treeHoleId = Integer.parseInt(treeHoleIdStr);
               intent.putExtra("treeHoleId", treeHoleId);
               intent.putExtra("content", viewHolder.content.getText().toString());
               parent.getContext().startActivity(intent);
           }
       });

       return viewHolder;
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       home home = homeList.get(position);
       holder.treeHoleId.setText(home.treeHoleId+"");
       holder.creator.setText(home.creator);
       holder.content.setText(home.content);
       holder.createTime.setText("2022-1-2");
   }

   @Override
   public int getItemCount() {
       return homeList.size();
   }
}
