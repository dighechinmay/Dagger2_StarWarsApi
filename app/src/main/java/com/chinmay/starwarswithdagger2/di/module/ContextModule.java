package com.chinmay.starwarswithdagger2.di.module;


import android.content.Context;

import com.chinmay.starwarswithdagger2.di.qualifiers.ApplicationContext;
import com.chinmay.starwarswithdagger2.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }


    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return context;
    }


}
