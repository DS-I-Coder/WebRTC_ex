package com.duksung.studywithme.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duksung.studywithme.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// search 결과화면 recyclerview에 대한 어댑터
public class SearchCategoryAdapter extends RecyclerView.Adapter<SearchCategoryAdapter.ViewHolder> {

    private ArrayList<String> mList
            = new ArrayList<String>(Arrays.asList("토익", "공무원", "중간고사","수능", "대학생", "직장인"
            ,"취업준비","한국사", "111", "222", "333"));

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_search_category, parent, false);

        return new SearchCategoryAdapter.ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str = mList.get(position);
        holder.textView.setText(str);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /* 뷰홀더 클래스 */
     class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_category_item);
        }
    }

}
