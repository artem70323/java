package com.gmail.androiddz.di;


import android.content.Context;

import com.gmail.androiddz.data.repository.UsersDataRepository;
import com.gmail.androiddz.data.repository.UsersRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//как конструируется компонент
@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    UsersRepository provideUserRepository(UsersDataRepository userDataRepository) {
        return userDataRepository;
    }

}
