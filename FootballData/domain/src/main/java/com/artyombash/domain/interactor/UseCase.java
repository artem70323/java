package com.artyombash.domain.interactor;

import com.artyombash.domain.executor.PostExecutionThread;
import com.artyombash.domain.executor.ThreadExecutor;
import com.google.common.base.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase<InParam, OutParam> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<OutParam> buildUseCase(InParam param);

    /**
     * Executes the current use case.
     *
     * @param disposableObserver {@link DisposableObserver} which will be listening to the
     * observable build by {@link #buildUseCase(InParam)} ()} method.
     * @param param Parameters (Optional) used to build/execute this use case.
     */
    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        Preconditions.checkNotNull(disposableObserver, "UseCase: disposableObserver is null");
        final Observable<OutParam> observable = this.buildUseCase(param)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(disposableObserver));
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if(!disposables.isDisposed()) {
            disposables.dispose();
        }
    }


    /**
     * Add a {@link Disposable} to {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable, "UseCase: disposable is null");
        Preconditions.checkNotNull(disposables, "UseCase: disposables is null");
        disposables.add(disposable);
    }

}
