package com.gmail.androiddz.dz10;


import android.databinding.ObservableField;

import com.gmail.androiddz.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;


public class Dz10ViewModel implements BaseViewModel {

    private Disposable disposable;

    public ObservableField<String> field = new ObservableField<>("");

    @Override
    public void init() {
    }

    @Override
    public void resume() {
        disposable = (Disposable) Observable.interval(1, TimeUnit.SECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong % 2 == 0;
                    }
                })
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(@NonNull Long aLong) throws Exception {
                        return String.valueOf(aLong);
                    }
                })
                .subscribeWith(new DisposableObserver<String>() {

                    @Override
                    public void onNext(@NonNull String s) {
                        field.set(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        field.set(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        field.set("finish");
                    }
                });
    }

    @Override
    public void pause() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void release() {
    }
}
