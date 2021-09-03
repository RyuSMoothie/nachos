package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;

public class AboutVeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_ve);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new Product("사이트", "비건" , "제품명", R.drawable.aboutve));
        adapter.addItem(new Product("사이트", "비건" , "제품명", R.drawable.aboutve));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +
                        "\n 설명 : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });


    }
}