package com.example.whatsapptest.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whatsapptest.R;
import com.example.whatsapptest.model.ChatModel;
import com.example.whatsapptest.ui.activity.Chat;
import com.example.whatsapptest.ui.activity.LoginPagePhoneNum;
import com.example.whatsapptest.ui.activity.Splash_Screen;
import com.example.whatsapptest.ui.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class ChatFragment extends Fragment implements RecyclerAdapter.ChatClickListener {
    RecyclerView recyclerView ;
    RecyclerAdapter recyclerAdapter;
    ArrayList <ChatModel> data = new ArrayList<>();

    public ChatFragment() {
        // Required empty public constructor
    }
    //TextView name ;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.chatRecyclerView);
//        name = view.findViewById(R.id.userName);
//        name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity()
//                        .getSupportFragmentManager()
//                        .beginTransaction()
//                        .add(R.id.main_container,new TestFragment())
//                        .addToBackStack("")
//                        .commit();
//
//
//            }
//        });
        setUp();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    private  void setUp (){
        addFakeData();
        recyclerAdapter = new RecyclerAdapter(data,this::onChatClick);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getContext()
        ));
    }
    private void addFakeData (){
        data.add(new ChatModel("Mai saad ","?????????????? ?????? ????????  ","11:11 pm",R.drawable.img1));
        data.add(new ChatModel("Shrouk taha","?????? ????????  ","10:33 pm ",R.drawable.img2));
        data.add(new ChatModel("Dina Sayed ","????????????  ","9:56 pm",R.drawable.img3));
        data.add(new ChatModel("Sara Ezat ","?? ??????  ","8:11 pm",R.drawable.img4));
        data.add(new ChatModel("Sama Mostafa ","************  ","7:14 pm",R.drawable.img5));
        data.add(new ChatModel("Manar Tarek ","???????? ????????  ","2:32 pm",R.drawable.img6));
        data.add(new ChatModel("Aya Refaat ","???????? ?? ???????? ","9/15/22",R.drawable.img7));
        data.add(new ChatModel("Saher Nayel","?????????? ?????? ??????????   ","9/13/22",R.drawable.img8));
        data.add(new ChatModel("Doaa Sayed"," ?????? ?????????????? ","9/10/22",R.drawable.img1));
        data.add(new ChatModel("Reem saad ","???????? ?????????? ?? ???????? ????????  ","8/22/22",R.drawable.img2));
        data.add(new ChatModel("Rodina saad ","???????? ???????? ","8/20/22",R.drawable.img3));
        data.add(new ChatModel("Shreen ","???????? ?????????? ????  ","7/30/22",R.drawable.img4));
        data.add(new ChatModel("Roza ","?????? ?????????? ","7/15/22",R.drawable.img5));
    }

    //this three methods for chat menu option

    //enable option menu in the fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    //inflate menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_chat_menu_items,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //handle menu item click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.NewGroup){
            Toast.makeText(getActivity(),"New group",Toast.LENGTH_LONG).show();
        }

        if (id == R.id.NewBroadcast){
            Toast.makeText(getActivity(),"New broadcast",Toast.LENGTH_LONG).show();
        }

        if (id == R.id.LinkedDevice){
            Toast.makeText(getActivity(),"Linked device",Toast.LENGTH_LONG).show();
        }

        if (id == R.id.StarredMessages){
            Toast.makeText(getActivity(),"Starred messages",Toast.LENGTH_LONG).show();
        }

        if (id == R.id.Sittings){
            Toast.makeText(getActivity(),"Settings",Toast.LENGTH_LONG).show();
        }

        if(id == R.id.search){
            Toast.makeText(getActivity(),"Search",Toast.LENGTH_LONG).show();
        }

        if(id == R.id.camera){
            Toast.makeText(getActivity(),"Camera",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onChatClick(ChatModel chatModel) {
        startActivity(new Intent(requireActivity() , Chat.class));
    }
}