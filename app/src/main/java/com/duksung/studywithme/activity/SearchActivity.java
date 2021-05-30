package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.fragment.SearchCategoryFragment;
import com.duksung.studywithme.fragment.SearchResultFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    EditText et_searchBar;
    FragmentTransaction transaction;
    SearchCategoryFragment categoryFragment;

    @Override
    public void onBackPressed() { // 뒤로가기 버튼을 눌렀을 때
        if (categoryFragment.isVisible()) { // 카테고리 보이는 화면일 때는
            super.finish(); // 현재 액티비티 종료
        }
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frameLayout_search, categoryFragment);
        transaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_searchBar = findViewById(R.id.et_searchBar);
        transaction = getSupportFragmentManager().beginTransaction();

        categoryFragment = new SearchCategoryFragment();
        transaction.addToBackStack(null);
        transaction.add(R.id.frameLayout_search, categoryFragment);
        transaction.commit();

        // 검색어 입력후 엔터키 입력 처리
        et_searchBar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){ // 엔터키입력
                    // 서버로 통신
                    // 결과 String 배열 return -> mList에 담아서 Bundle로 결과fragment에 전달.

                    // 임시 데이터
                   ArrayList<String> testList
                            = new ArrayList<>(Arrays.asList("덕성여대 중간고사", "컴공 중간고사", "중간고사 D-14"));

                    SearchResultFragment fragment = new SearchResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("m", testList);
                    fragment.setArguments(bundle);
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.frameLayout_search, fragment);
                    transaction.commit();
                    return true;
                }
                return false;
            }
        });


        /*
        실시간 처리 필요?
         */
    }
}