package com.singh.ranjeet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;
    ArrayList<show> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        listView = (RecyclerView) findViewById(R.id.listview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(mLayoutManager);


    final ApiInterface apiInterface =
            retrofit.getClient(this).create(ApiInterface.class);
          apiInterface.getTopStories().enqueue(new Callback<List<Integer>>() {
        @Override
        public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
            List<Integer> topStories = response.body();
            for (int i = 0; i < 10; i++) {
                apiInterface.getArticle(topStories.get(i)).enqueue(new Callback<model>() {
                    @Override
                    public void onResponse(Call<model> call, Response<model> response) {
                        String title= response.body().getTitle().toString();
                        String url = response.body().getUrl().toString();
                        String by = response.body().getBy().toString();
String date=response.body().toString();

                        list.add(new show(title,555,by,url));
                        NewsRecyclerViewAdapter adapter=new NewsRecyclerViewAdapter(MainActivity.this
                               ,MainActivity. this,list);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<model> call, Throwable t) {

                    }
                });
            }
        }

        @Override
        public void onFailure(Call<List<Integer>> call, Throwable t) {

        }
    });
}
}