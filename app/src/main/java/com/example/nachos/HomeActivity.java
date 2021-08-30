package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Integer> imageList;
    private static final int DP = 24; //수치가 높을수록 옆에 그림이 조금씩 더 많이보임

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.initializeData();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));
    }

    public void initializeData() //이미지를 저장함 배열에
    {
        imageList = new ArrayList();

        imageList.add(R.drawable.aboutve);
        imageList.add(R.drawable.aboutve);
        imageList.add(R.drawable.aboutve);
        imageList.add(R.drawable.aboutve);
        imageList.add(R.drawable.aboutve);
    }
}