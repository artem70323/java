package com.artyombash.presentation.viewModel;

import android.databinding.ObservableField;
import android.util.Log;

import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.interactor.GetCompetitions;
import com.artyombash.presentation.adapter.CompetitionAdapter;
import com.artyombash.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class MainViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private GetCompetitions getCompetitions;
    public CompetitionAdapter adapter = new CompetitionAdapter();

    @Inject
    public MainViewModel(GetCompetitions getCompetitions) {
        this.getCompetitions = getCompetitions;
    }

    @Override
    public void init() {

    }

    @Override
    public void resume() {

        getCompetitions.execute
                (null, new DisposableObserver<List<Competition>>() {

                    @Override
                    public void onNext(@NonNull List<Competition> competitions) {
                        adapter.setItems(competitions);
                        state.set(STATE.DATA);
                        Log.e("Competition", competitions.get(0).getLastUpdated());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("Error", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("onComplete", "Complete");
                    }
                });
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
