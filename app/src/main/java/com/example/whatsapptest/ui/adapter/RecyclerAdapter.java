package com.example.whatsapptest.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapptest.R;
import com.example.whatsapptest.model.ChatModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.chatHolder>{
    private List<ChatModel> chat ;
    private ChatClickListener chatClickListener ;

    public RecyclerAdapter(List<ChatModel> chat , ChatClickListener chatClickListener) {
        this.chat = chat;
        this.chatClickListener =chatClickListener;
    }
    @NonNull
    @Override
    public chatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_layout,parent,false);
        return new chatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatHolder holder, int position) {
        ChatModel chatModel = chat.get(position);
        holder.userImg.setImageResource(chatModel.getUserImage());
        holder.userName.setText(chatModel.getUserName());
        holder.contents.setText(chatModel.getContants());
        holder.timeChat.setText(chatModel.getTimeChat());
    }


    @Override
    public int getItemCount() {
        if (chat != null)
            return chat.size();
        return 0;
    }

     class chatHolder extends RecyclerView.ViewHolder {
        TextView userName , contents ,timeChat ;
        ImageView userImg ;
        public chatHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userImg = itemView.findViewById(R.id.userImg);
            contents = itemView.findViewById(R.id.Contents);
            timeChat = itemView.findViewById(R.id.timeChat);

            itemView.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chatClickListener.onChatClick(chat.get(getLayoutPosition()));
                }
            });

        }
    }

   public interface ChatClickListener{
       void onChatClick(ChatModel chatModel);
    }
}
