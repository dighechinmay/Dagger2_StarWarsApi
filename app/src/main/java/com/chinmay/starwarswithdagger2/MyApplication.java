package com.chinmay.starwarswithdagger2;

import android.app.Activity;
import android.app.Application;

import com.chinmay.starwarswithdagger2.di.components.ApplicationComponent;
import com.chinmay.starwarswithdagger2.di.components.DaggerApplicationComponent;
import com.chinmay.starwarswithdagger2.di.module.ContextModule;

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
    }


    public static MyApplication get(Activity activity){
        return (MyApplication)activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
