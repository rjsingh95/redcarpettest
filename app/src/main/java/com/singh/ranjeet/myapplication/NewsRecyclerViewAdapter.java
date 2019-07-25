package com.singh.ranjeet.myapplication;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;


public class NewsRecyclerViewAdapter extends RecyclerView
        .Adapter<NewsRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<show> list;
    Activity main;


    private static MyClickListener myClickListener;
    private Context context;
    private WebView mWebview;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            {


        private final View mview;
        private final TextView by;

        private final TextView time2;
        TextView title;



        public DataObjectHolder(View itemView) {
            super(itemView);


            mview = itemView;
            title = (TextView) itemView.findViewById(R.id.news);
            by = (TextView) itemView.findViewById(R.id.by);
            time2 = (TextView) itemView.findViewById(R.id.time);


        }


    }


    public NewsRecyclerViewAdapter(Activity activity, Context context, ArrayList<show> list) {

        this.main = activity;
        this.context = context;
        this.list = list;
    }


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);


        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {


        holder.title.setText(list.get(position).getTitle());
        holder.by.setText("By " + list.get(position).getBywho());

        GetTimeAgo getTimeAgo = new GetTimeAgo();


        String lastSeenTime = getTimeAgo.getTimeAgo(list.get(position).getDate(), context);

    holder.    time2.setText(lastSeenTime);
        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent productdetailsintent = new Intent(context,fullarticle.class);
                productdetailsintent.putExtra("url",list.get(position).getUrl());
                v.getContext().startActivity(productdetailsintent);

            }
        });


    }

    public void deleteItem(int index) {
        list.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);

    }


}
