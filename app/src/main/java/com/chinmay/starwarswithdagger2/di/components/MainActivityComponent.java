package com.chinmay.starwarswithdagger2.di.components;


import android.content.Context;

import com.chinmay.starwarswithdagger2.MainActivity;
import com.chinmay.starwarswithdagger2.di.module.AdapterModule;
import com.chinmay.starwarswithdagger2.di.qualifiers.ActivityContext;
import com.chinmay.starwarswithdagger2.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = AdapterModule.class,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {


    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);
}
