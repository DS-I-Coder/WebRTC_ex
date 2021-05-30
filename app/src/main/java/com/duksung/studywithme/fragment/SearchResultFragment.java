package com.duksung.studywithme.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchResultFragment extends Fragment {

    ArrayList<String> mList = new ArrayList<>();
    Button btn_seemore;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_result, container, false);

        btn_seemore = view.findViewById(R.id.btn_seemore);

        //Bundle로 받아온 결과 mList
        mList = getArguments().getStringArrayList("m");
        Log.d("dd",mList.get(0));
        SearchAdapter adapter = new SearchAdapter(mList);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_search_result);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
