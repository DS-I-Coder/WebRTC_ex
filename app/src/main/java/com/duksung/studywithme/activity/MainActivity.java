package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.MainBestMemberAdapter;
import com.duksung.studywithme.model.MainBestMemberModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_searchBar;
    ViewPager viewpager;

    List<MainBestMemberModel> models;
    MainBestMemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_searchBar = findViewById(R.id.tv_searchBar);
        viewpager = findViewById(R.id.main_viewpager);

        models = new ArrayList<>();
        models.add(new MainBestMemberModel("분야"));
        models.add(new MainBestMemberModel("나이이"));

        adapter = new MainBestMemberAdapter(models, this);
        viewpager.setPadding(0, 0, 50, 0);
        viewpager.setAdapter(adapter);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tv_searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.not_move); // 화면전환 애니메이션
            }
        });


    }
}