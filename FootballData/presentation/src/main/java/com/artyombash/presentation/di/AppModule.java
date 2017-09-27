package com.artyombash.presentation.di;

import android.content.Context;

import com.artyombash.data.cache.Cache;
import com.artyombash.data.cache.CacheImpl;
import com.artyombash.data.executor.JobExecutor;
import com.artyombash.data.repository.FootballDataRepository;
import com.artyombash.domain.executor.PostExecutionThread;
import com.artyombash.domain.executor.ThreadExecutor;
import com.artyombash.domain.repository.FootballRepository;
import com.artyombash.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    Cache provideCache(CacheImpl cache) {
        return cache;
    }

    @Provides
    @Singleton
    FootballRepository provideFootballRepository(FootballDataRepository repository) {
        return repository;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


}
