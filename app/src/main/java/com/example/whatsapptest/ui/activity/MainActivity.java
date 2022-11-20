package com.example.whatsapptest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.whatsapptest.R;
import com.example.whatsapptest.ui.adapter.MainViewPagerAdapter;
import com.example.whatsapptest.ui.fragment.ChatFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mainView;
    private MainViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        //showFragment(new ChatFragment());
    }
    private void initUi () {
        viewPagerAdapter =new MainViewPagerAdapter(getSupportFragmentManager(),this.getLifecycle(),3);
        mainView = findViewById(R.id.viewpagerContainer);
        tabLayout = findViewById(R.id.tabLayout);
        mainView.setAdapter(viewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainView.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_camera_alt_24);
    }

//    private void showFragment (Fragment fragment){
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_container,fragment)
//                .commit();
//
//    }

}