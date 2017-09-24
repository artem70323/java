package com.gmail.androiddz;

import android.app.Application;

import com.gmail.androiddz.di.AppComponent;
import com.gmail.androiddz.di.AppModule;
import com.gmail.androiddz.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;


public class TestApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);


        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
