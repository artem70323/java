package com.gmail.androiddz.domain.interaction.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<InParam, OutParam> {

    private Disposable disposable;

    protected abstract Observable<OutParam> buildUseCase(InParam param);

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        disposable = buildUseCase(param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(disposableObserver);
    }

    public void dispose() {
        if(!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
