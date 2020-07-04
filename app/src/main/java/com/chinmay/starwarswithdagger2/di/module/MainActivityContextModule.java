package com.chinmay.starwarswithdagger2.di.module;




import android.content.Context;

import com.chinmay.starwarswithdagger2.MainActivity;
import com.chinmay.starwarswithdagger2.di.qualifiers.ActivityContext;
import com.chinmay.starwarswithdagger2.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;

    public Context context;


    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity(){
        return mainActivity;
    }



    @Provides
    @ActivityScope
    @ActivityContext
    public Context providesContext(){
        return context;
    }

}
