package com.duksung.studywithme.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.SearchAdapter;
import com.duksung.studywithme.adapter.SearchCategoryAdapter;

import java.util.ArrayList;

public class SearchCategoryFragment extends Fragment {

    EditText searchBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_category, container, false);

        SearchCategoryAdapter adapter = new SearchCategoryAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_search_category);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
