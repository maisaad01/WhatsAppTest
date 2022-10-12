package com.example.whatsapptest.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapptest.R;
import com.example.whatsapptest.model.CallModel;

import java.util.List;

public class RecyclerCallAdapter extends RecyclerView.Adapter <RecyclerCallAdapter.callHolder> {
    private List<CallModel> call ;

    public RecyclerCallAdapter(List<CallModel> call) {
        this.call = call;
    }

    @NonNull
    @Override
    public callHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calls_layout,parent,false);
        return new callHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull callHolder holder, int position) {
        CallModel callModel = call.get(position);
        holder.userImgCall.setImageResource(callModel.getImageCall());
        holder.userNameCall.setText(callModel.getUserNameCall());
        holder.timeCall.setText(callModel.getTimeCall());

    }

    @Override
    public int getItemCount() {
        if (call != null)
            return call.size();
        return 0;
    }

    static class callHolder extends RecyclerView.ViewHolder {
        TextView userNameCall , timeCall ;
        ImageView userImgCall ;

        public callHolder(@NonNull View itemView) {
            super(itemView);
            userImgCall = itemView.findViewById(R.id.user_call_img);
            userNameCall = itemView.findViewById(R.id.userName_call);
            timeCall = itemView.findViewById(R.id.timeCalls);
        }
    }
}
