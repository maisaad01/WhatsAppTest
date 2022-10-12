package com.example.whatsapptest.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsapptest.R;
import com.example.whatsapptest.model.CallModel;
import com.example.whatsapptest.ui.adapter.RecyclerCallAdapter;

import java.util.ArrayList;

public class CallsFragment extends Fragment {
    RecyclerView recyclerViewCall ;
    RecyclerCallAdapter recyclerCallAdapter ;
    ArrayList <CallModel> callData = new ArrayList<>();

    public CallsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewCall = view.findViewById(R.id.callRecyclerView);
        setupCall ();
    }
    private void setupCall (){
        addFakeDataCall();
        recyclerCallAdapter = new RecyclerCallAdapter(callData);
        recyclerViewCall.setAdapter(recyclerCallAdapter);
        recyclerViewCall.setLayoutManager(new LinearLayoutManager(
                getContext()
        ));

    }
    private void addFakeDataCall (){
        callData.add(new CallModel("Mai Saad","5 September , 11:35 pm",R.drawable.img1));
        callData.add(new CallModel("Reem Saad","4 September , 10:25 pm",R.drawable.img2));
        callData.add(new CallModel("Ahmed Saad","3 September , 7:40 pm",R.drawable.img3));
        callData.add(new CallModel("Sara ","2 September , 3:19 pm",R.drawable.img4));
        callData.add(new CallModel("Sahar","1 September , 11: 00 pm",R.drawable.img5));
        callData.add(new CallModel("Rodina","5 June , 11 :35 pm",R.drawable.img6));
        callData.add(new CallModel("Rana ","5 July , 11 :35 pm",R.drawable.img7));
        callData.add(new CallModel("Shrouk","5 April , 11 :35 pm",R.drawable.img8));
        callData.add(new CallModel("Sama","5 May , 11 :35 pm",R.drawable.img1));
        callData.add(new CallModel("Dina","5 September , 11 :35 pm",R.drawable.img2));
        callData.add(new CallModel("Shrouk","5 September , 11 :35 pm",R.drawable.img3));
        callData.add(new CallModel("Doaa","5 September , 11 :35 pm",R.drawable.img4));
        callData.add(new CallModel("Roza","5 September , 11 :35 pm",R.drawable.img5));
        callData.add(new CallModel("Salma","5 September , 11 :35 pm",R.drawable.img6));
        callData.add(new CallModel("Esraa","5 September , 11 :35 pm",R.drawable.img7));
        callData.add(new CallModel("Dalia","5 September , 11 :35 pm",R.drawable.img8));
        callData.add(new CallModel("DoDo","5 September , 11 :35 pm",R.drawable.img1));

    }
    //three methods for option call menu

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.options_call_menu_items,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ClearCallLog){
            Toast.makeText(getActivity(),"Clear call log",Toast.LENGTH_LONG).show();
        }

        if (id == R.id.SittingsCall){
            Toast.makeText(getActivity(),"Settings",Toast.LENGTH_LONG).show();
        }

        if(id == R.id.search){
            Toast.makeText(getActivity(),"Search",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}