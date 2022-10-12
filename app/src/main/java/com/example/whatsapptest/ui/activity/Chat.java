package com.example.whatsapptest.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.whatsapptest.R;
import com.example.whatsapptest.databinding.ActivityChatBinding;
import com.example.whatsapptest.model.ChatMessageModel;
import com.example.whatsapptest.ui.adapter.RecyclerAdapterSendMessageChat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
    private ActivityChatBinding binding ;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    public final String USER_ID = "A123" ;
    ArrayList <ChatMessageModel> messageModels = new ArrayList<>();
    RecyclerAdapterSendMessageChat Adapter = new RecyclerAdapterSendMessageChat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = binding.enterMessage.getText().toString().trim();
                if (!message.isEmpty())
                    sendMessages(message);

            }

        });
        getData();
    }
    private void sendMessages (String message){
        ref.child("message").push().setValue(new ChatMessageModel(message,USER_ID));
        binding.enterMessage.setText("");

    }
    private void getData (){
        ref.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    messageModels.add(snapshot1.getValue(ChatMessageModel.class));

                }
                //Adapter.setList(messageModels);
                binding.RecyclerViewMessages.setAdapter(Adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}