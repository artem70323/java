package com.gmail.androiddz;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;


public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

}
