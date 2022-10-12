package com.example.whatsapptest.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapptest.R;
import com.example.whatsapptest.model.StatusModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerStatusAdapter extends RecyclerView.Adapter <RecyclerStatusAdapter.statusHolder>{
    private List<StatusModel> status;

    public RecyclerStatusAdapter(List<StatusModel> status) {
        this.status = status;
    }

    @NonNull
    @Override
    public statusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext())
                .inflate(R.layout.item_status_layout,parent,false);
        return new statusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull statusHolder holder, int position) {
        StatusModel statusModel = status.get(position);
        holder.userImgStatus.setImageResource(statusModel.getImageStatus());
        holder.userNameStatus.setText(statusModel.getUserNameStatus());
        holder.timeStatus.setText(statusModel.getTimeStatus());

    }

    @Override
    public int getItemCount() {
        if (status != null)
            return status.size();
        return 0;
    }

    static class statusHolder extends RecyclerView.ViewHolder{
        TextView userNameStatus , timeStatus ;
        ImageView userImgStatus ;

        public statusHolder(@NonNull View itemView) {
            super(itemView);
            userImgStatus = itemView.findViewById(R.id.user_status_img);
            userNameStatus = itemView.findViewById(R.id.userName_status);
            timeStatus = itemView.findViewById(R.id.timeStatus);
        }
    }
}
