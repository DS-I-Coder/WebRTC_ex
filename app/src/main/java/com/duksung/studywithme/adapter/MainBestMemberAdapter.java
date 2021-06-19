package com.duksung.studywithme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.duksung.studywithme.R;
import com.duksung.studywithme.activity.DataChartActivity;
import com.duksung.studywithme.model.MainBestMemberModel;

import org.w3c.dom.Text;

import java.util.List;

public class MainBestMemberAdapter extends PagerAdapter {

    private List<MainBestMemberModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public MainBestMemberAdapter(List<MainBestMemberModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_main_bestmember, container, false);

        TextView title;

        title = view.findViewById(R.id.tv_title);

        title.setText("[ "+models.get(position).getTitle()+" ]");


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DataChartActivity.class);
                context.startActivity(intent);
            }
        });
        container.addView(view, 0);
        return view;
    }
}
