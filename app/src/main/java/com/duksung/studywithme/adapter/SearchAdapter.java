package com.duksung.studywithme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.duksung.studywithme.R;
import java.util.ArrayList;

// search 결과화면 recyclerview에 대한 어댑터
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<String> mList;

    public SearchAdapter(ArrayList<String> mList) {

        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_search_result, parent, false);

        return new SearchAdapter.ViewHolder(root);
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
            textView = itemView.findViewById(R.id.tv_result_item);
        }
    }

}
