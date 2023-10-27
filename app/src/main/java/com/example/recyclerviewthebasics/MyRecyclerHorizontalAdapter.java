package com.example.recyclerviewthebasics;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerHorizontalAdapter extends RecyclerView.Adapter<MyRecyclerHorizontalAdapter.MyViewHolder>{
    private Context context;
    private String[] interns;
    private int[] avatars;

    public MyRecyclerHorizontalAdapter(View view1) {
    }

    public MyRecyclerHorizontalAdapter(Context context, String[] interns, int[] avatars) {
        this.context = context;
        this.interns = interns;
        this.avatars = avatars;
    }

    @NonNull
    @Override
    public MyRecyclerHorizontalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_recycler_horizontal,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerHorizontalAdapter.MyViewHolder holder, int position) {
        holder.tvTitre1.setText(interns[position]);
        holder.ivAvatar1.setImageResource(avatars[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("intern",interns[position]);
                intent.putExtra("avatar",avatars[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar1;
        private TextView tvTitre1;
        private ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar1 = itemView.findViewById(R.id.iv_avatar1);
            tvTitre1 = itemView.findViewById(R.id.tv_titre1);
            mainLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
