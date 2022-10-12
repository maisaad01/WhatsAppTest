package com.example.whatsapptest.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.whatsapptest.ui.fragment.CallsFragment;
import com.example.whatsapptest.ui.fragment.ChatFragment;
import com.example.whatsapptest.ui.fragment.StatusFragment;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    private int count;
    public MainViewPagerAdapter(@NonNull FragmentManager fragmentManager,
                                @NonNull Lifecycle lifecycle , int count) {
        super(fragmentManager, lifecycle);
        this.count=count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new ChatFragment();
            case 1 :
                return new CallsFragment();
            case 2 :
                return new StatusFragment();
        }
        return new Fragment();
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
