package com.gmail.androiddz;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;


public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        Realm.init(this);
    }

}
