package com.gmail.androiddz.dz11;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.data.repository.UsersDataRepository;
import com.gmail.androiddz.domain.entity.ProfileDomain;
import com.gmail.androiddz.domain.interaction.GetProfilesListUseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class Dz11ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;

    public Dz11ViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfilesListUseCase getProfileListUseCase = new GetProfilesListUseCase();

    public ProfileAdapter adapter = new ProfileAdapter();

    @Override
    public void init() {}

    @Override
    public void resume() {

        getProfileListUseCase.execute
                (new UsersDataRepository(activity), new DisposableObserver<List<ProfileDomain>>(){

            @Override
            public void onNext(List<ProfileDomain> profileModels) {
                adapter.setItems(profileModels);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("onComplete", "onComplete");
            }
        });
    }

    @Override
    public void pause() {
        //getProfileListUseCase.dispose();
    }

    @Override
    public void release() {
    }
}
