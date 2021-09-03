package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        ListView listView = findViewById(R.id.SiteList1);
        ListView listView2 = findViewById(R.id.SiteList2);
        ListView listView_ani = findViewById(R.id.SiteList_ani);
        ListView listView_do = findViewById(R.id.SiteList_do);
        ListView listView_fair = findViewById(R.id.SiteList_fair);
        ListView listView_pla = findViewById(R.id.SiteList_pla);
        ListView listView_up = findViewById(R.id.SiteList_up);
        ListView listView_ve = findViewById(R.id.SiteList_ve);

        SiteAdapter adapter = new SiteAdapter();
        adapter.addItem(new SiteItem("프라이탁", "업사이클링",R.drawable.back_animal));
        listView.setAdapter(adapter);
        listView2.setAdapter(adapter);
        listView_ani.setAdapter(adapter);
        listView_do.setAdapter(adapter);
        listView_fair.setAdapter(adapter);
        listView_pla.setAdapter(adapter);
        listView_up.setAdapter(adapter);
        listView_ve.setAdapter(adapter);


    }

    class SiteAdapter extends BaseAdapter {
        //데이터가 들어가있지 않고, 어떻게 담을지만 정의해뒀다.
        ArrayList<SiteItem> items = new ArrayList<SiteItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SiteItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 어댑터가 데이터를 관리하고 뷰도 만듬
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SiteItemView siteItemView = null;
            // 코드를 재사용할 수 있도록
            if(convertView == null) {
                siteItemView = new SiteItemView(getApplicationContext());
            } else {
                siteItemView = (SiteItemView)convertView;
            }
            SiteItem item = items.get(position);
            siteItemView.setSite(item.getSite());
            siteItemView.setCategory(item.getCategory());
            siteItemView.setImage(item.getResId());
            siteItemView.setButton(item.getGotosite());
            return siteItemView;
        }
    }
}