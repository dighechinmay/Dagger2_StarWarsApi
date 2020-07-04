package com.chinmay.starwarswithdagger2.di.components;

import com.chinmay.starwarswithdagger2.DetailActivity;
import com.chinmay.starwarswithdagger2.di.scope.ActivityScope;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public
interface DetailActivityComponent {

    void injectDetailActivity(DetailActivity detailActivity);
}
