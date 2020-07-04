package com.chinmay.starwarswithdagger2.di.components;


import android.content.Context;

import com.chinmay.starwarswithdagger2.MyApplication;
import com.chinmay.starwarswithdagger2.di.module.ContextModule;
import com.chinmay.starwarswithdagger2.di.module.RetrofitModule;
import com.chinmay.starwarswithdagger2.di.qualifiers.ApplicationContext;
import com.chinmay.starwarswithdagger2.di.scope.ApplicationScope;
import com.chinmay.starwarswithdagger2.retrofit.ApiInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {


    public ApiInterface getApiInterface();


    @ApplicationContext
    public Context getContext();


    public void injectApplication(MyApplication myApplication);



}
