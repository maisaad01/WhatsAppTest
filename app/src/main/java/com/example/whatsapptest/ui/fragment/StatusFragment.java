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
import com.example.whatsapptest.model.ChatModel;
import com.example.whatsapptest.model.StatusModel;
import com.example.whatsapptest.ui.adapter.RecyclerStatusAdapter;

import java.util.ArrayList;


public class StatusFragment extends Fragment {
    RecyclerView recyclerViewStatus ;
    RecyclerStatusAdapter recyclerStatusAdapter;
    ArrayList<StatusModel> dataStatus = new ArrayList<>();
    public StatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewStatus = view.findViewById(R.id.statusRecyclerView);
        setUpStatus ();
    }

    private void setUpStatus() {
        addFakeDataStatus();
        RecyclerStatusAdapter recyclerStatusAdapter = new RecyclerStatusAdapter(dataStatus);
        recyclerViewStatus.setAdapter(recyclerStatusAdapter);
        recyclerViewStatus.setLayoutManager(new LinearLayoutManager(
                getContext()
        ));
    }

    private void addFakeDataStatus() {
        dataStatus.add(new StatusModel("Mai ","7 minutes ago",R.drawable.img1));
        dataStatus.add(new StatusModel("Reem ","10 minutes ago",R.drawable.img8));
        dataStatus.add(new StatusModel("Sara ","30 minutes ago",R.drawable.img7));
        dataStatus.add(new StatusModel("Rodina ","49 minutes ago",R.drawable.img6));
        dataStatus.add(new StatusModel("Aya ","Today, 8:28 pm",R.drawable.img5));
        dataStatus.add(new StatusModel("Salma ","Today, 7:10 pm",R.drawable.img4));
        dataStatus.add(new StatusModel("Asmaa ","Today, 4:48 pm",R.drawable.img3));
        dataStatus.add(new StatusModel("Dalia ","Today, 3:18 pm",R.drawable.img2));
        dataStatus.add(new StatusModel("Dina ","Today, 2:28 pm",R.drawable.img1));
        dataStatus.add(new StatusModel("Doaa ","Today, 2:28 pm",R.drawable.img7));
        dataStatus.add(new StatusModel("Roza ","Yesterday, 10:28 pm",R.drawable.img6));
        dataStatus.add(new StatusModel("Amira ","Yesterday, 9:55 pm",R.drawable.img5));
        dataStatus.add(new StatusModel("Lila","Yesterday, 8:40 pm",R.drawable.img4));
        dataStatus.add(new StatusModel("Shrouk ","Yesterday, 7:18 pm",R.drawable.img3));
        dataStatus.add(new StatusModel("Sahar ","Yesterday, 6:36 pm",R.drawable.img2));
        dataStatus.add(new StatusModel("Maha ","Yesterday, 7:28 pm",R.drawable.img1));

    }

    //three methods for option status menu
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_status_menu_items,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.StatusPrivacy){
            Toast.makeText(getActivity(),"Status privacy",Toast.LENGTH_LONG).show();
        }

        if (id == R.id.SittingsStatus){
            Toast.makeText(getActivity(),"Settings",Toast.LENGTH_LONG).show();
        }

        if(id == R.id.search){
            Toast.makeText(getActivity(),"Search",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}