package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.ResultAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {

    EditText et_searchBar;
    RecyclerView rc_resultList;
    ResultAdapter adapter;
    private ArrayList<String> mList
            = new ArrayList<String>(Arrays.asList("덕성여대 중간고사","컴공 중간고사","중간고사 D-14"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        et_searchBar = findViewById(R.id.et_searchBar);
        rc_resultList = findViewById(R.id.rc_resultList);

        adapter = new ResultAdapter(mList, this);
        rc_resultList.setAdapter(adapter);

        Intent intent = getIntent();
        et_searchBar.setText(intent.getStringExtra("category"));

    }
}