package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragementAdapter adapter;
    TabLayout tablayout;
    LinearLayout home_page, cate_page, prod_page,  stor_page;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tablayout = findViewById(R.id.tablayout);
        tablayout.addOnTabSelectedListener(onTabSelectedListener);

        home_page = findViewById(R.id.tab_home);
        cate_page = findViewById(R.id.tab_cate);
        prod_page = findViewById(R.id.tab_prod);
        stor_page = findViewById(R.id.tab_stor);


        context = this;
    }

    TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int pos = tab.getPosition();
            changeView(pos);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    private void changeView(int index) {
        switch (index) {
            case 0:
                home_page.setVisibility(View.VISIBLE);
                cate_page.setVisibility(View.INVISIBLE);
                prod_page.setVisibility(View.INVISIBLE);
                stor_page.setVisibility(View.INVISIBLE);
                break;
            case 1:
                home_page.setVisibility(View.INVISIBLE);
                cate_page.setVisibility(View.VISIBLE);
                prod_page.setVisibility(View.INVISIBLE);
                stor_page.setVisibility(View.INVISIBLE);
                break;
            case 2:
                home_page.setVisibility(View.INVISIBLE);
                cate_page.setVisibility(View.INVISIBLE);
                prod_page.setVisibility(View.VISIBLE);
                stor_page.setVisibility(View.INVISIBLE);
                break;
            case 3:
                home_page.setVisibility(View.INVISIBLE);
                cate_page.setVisibility(View.INVISIBLE);
                prod_page.setVisibility(View.INVISIBLE);
                stor_page.setVisibility(View.VISIBLE);
                break;

            /*** 숨언니꺼 잠시 주석... by 지수...
             tabLayout=findViewById(R.id.tabs);
             viewPager=findViewById(R.id.view_pager);
             adapter=new FragementAdapter(getSupportFragmentManager(),1);

             //FragmentAdapter에 컬렉션 담기
             adapter.addFragment(new SiteActivity());

             //ViewPager Fragment 연결
             viewPager.setAdapter(adapter);

             //ViewPager과 TabLayout 연결
             tabLayout.setupWithViewPager(viewPager);

             tabLayout.getTabAt(0).setText("첫 번째");
             ***/
        }

    }
}