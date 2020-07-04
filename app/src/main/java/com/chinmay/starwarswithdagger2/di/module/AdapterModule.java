package com.chinmay.starwarswithdagger2.di.module;

import androidx.recyclerview.widget.RecyclerView;

import com.chinmay.starwarswithdagger2.MainActivity;
import com.chinmay.starwarswithdagger2.di.adapter.RecyclerViewAdapter;
import com.chinmay.starwarswithdagger2.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {


    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeoplesList(RecyclerViewAdapter.ClickListener clickListener){
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity){
        return mainActivity;
    }
}
