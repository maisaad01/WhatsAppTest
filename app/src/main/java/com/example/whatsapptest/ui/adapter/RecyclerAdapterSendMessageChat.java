package com.example.whatsapptest.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapptest.R;
import com.example.whatsapptest.databinding.ItemChatMessageBinding;
import com.example.whatsapptest.model.ChatMessageModel;

import java.util.ArrayList;

public class RecyclerAdapterSendMessageChat extends RecyclerView.Adapter<RecyclerAdapterSendMessageChat.messageHolder> {
    ArrayList <ChatMessageModel> message ;

    public void setMessage(ArrayList<ChatMessageModel> message) {
        this.message = message;
    }

    @NonNull
    @Override
    public messageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatMessageBinding binding = ItemChatMessageBinding.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_message,parent,false));
        return new messageHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull messageHolder holder, int position) {
        ChatMessageModel chatMessageModel = message.get(position);
        holder.binding.textMessage.setText(chatMessageModel.getMessage());

    }

    @Override
    public int getItemCount() {
        //Elves operator instead of if
        return message == null ? 0 : message.size();
    }

    static class messageHolder extends RecyclerView.ViewHolder {
        ItemChatMessageBinding binding ;

        public messageHolder(@NonNull ItemChatMessageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
