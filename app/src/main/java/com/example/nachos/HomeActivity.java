package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Integer> imageList;
    private static final int DP = 24; //수치가 높을수록 옆에 그림이 조금씩 더 많이보임
    private RecyclerView listview;
    private MyAdapter adapter;

    EditText keyword;
    Button add_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.initializeData();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);

        keyword = findViewById(R.id.text71);
        add_bt = findViewById(R.id.insert_key);

        Button aboutve;
        aboutve = findViewById(R.id.goto_ve);

        // About 비건 페이지 이동
        aboutve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, AboutVeActivity.class);
                    startActivity(intent);
            }
        });

        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));


        ArrayList<String> itemList = new ArrayList<>();
        init(itemList);
        itemList.add(0," #친환경 ");
        itemList.add(1," #제로웨이스트 ");
        itemList.add(2," #플로깅 ");

        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init(itemList); // 버튼 누르면 init()호출
            }
        });

    }

    private void init(ArrayList<String> itemList) {

        listview = findViewById(R.id.recycler1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);

        String word = keyword.getText().toString(); //입력한 문자 받아옴
        if (word.length() > 0) {
            itemList.add(" #" +word +" "); //아이템 리스트에 추가
        }


        adapter = new MyAdapter(this, itemList, onClickItem);
        listview.setAdapter(adapter);

        MyListDecoration decoration = new MyListDecoration();
        listview.addItemDecoration(decoration);
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(HomeActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    };



    public void initializeData() //이미지를 저장함 배열에
    {
        imageList = new ArrayList();

        imageList.add(R.drawable.home_meaning);
        imageList.add(R.drawable.main_vegan);
        imageList.add(R.drawable.home_meaning);
        imageList.add(R.drawable.main_vegan);
        imageList.add(R.drawable.home_meaning);


    }


}