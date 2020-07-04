package com.chinmay.starwarswithdagger2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.chinmay.starwarswithdagger2.di.adapter.RecyclerViewAdapter;
import com.chinmay.starwarswithdagger2.di.components.ApplicationComponent;
import com.chinmay.starwarswithdagger2.di.components.DaggerMainActivityComponent;
import com.chinmay.starwarswithdagger2.di.components.MainActivityComponent;
import com.chinmay.starwarswithdagger2.di.module.MainActivityContextModule;
import com.chinmay.starwarswithdagger2.di.qualifiers.ActivityContext;
import com.chinmay.starwarswithdagger2.di.qualifiers.ApplicationContext;
import com.chinmay.starwarswithdagger2.pojo.StarWars;
import com.chinmay.starwarswithdagger2.retrofit.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private static String TAG = "MainActivity";

    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;


    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public ApiInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    Context activityContext;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        apiInterface.getPeople("json").enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                populateRecyclerView(response.body().results);
            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {

            }
        });

    }

    private void populateRecyclerView(List<StarWars.People> results) {
        recyclerViewAdapter.setData(results);
    }


    @Override
    public void launchIntent(String url) {
        Toast.makeText(mContext, "RecyclerView Row selected", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(activityContext, DetailActivity.class).putExtra("url", url));
    }

}