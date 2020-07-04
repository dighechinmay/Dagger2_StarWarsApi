package com.chinmay.starwarswithdagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.chinmay.starwarswithdagger2.di.components.ApplicationComponent;
import com.chinmay.starwarswithdagger2.di.components.DaggerDetailActivityComponent;
import com.chinmay.starwarswithdagger2.di.components.DetailActivityComponent;
import com.chinmay.starwarswithdagger2.di.qualifiers.ApplicationContext;
import com.chinmay.starwarswithdagger2.pojo.Films;
import com.chinmay.starwarswithdagger2.retrofit.ApiInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    DetailActivityComponent detailActivityComponent;

    @Inject
    public ApiInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.textView);

        String url = getIntent().getStringExtra("url");

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

        detailActivityComponent.injectDetailActivity(this);

        apiInterface.getFilmData(url, "json").enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                Films films = response.body();
                String text = "Film name:\n" + films.title + "\nDirector:\n" + films.director;
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {

            }
        });
    }
}
