package com.duksung.studywithme.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {
    RecyclerView rc_categoryList;
    SearchAdapter searchAdapter;
    private ArrayList<String> mList
            = new ArrayList<>(Arrays.asList("토익", "공무원", "중간고사", "수능", "대학생", "직장인"
            , "취업준비", "한국사", "로스쿨", "임용고시", "외국어"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rc_categoryList = findViewById(R.id.rc_categoryList);

        searchAdapter = new SearchAdapter(mList, this);
        rc_categoryList.setAdapter(searchAdapter);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right_out, R.anim.not_move);
    }
}