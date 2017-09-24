package com.gmail.androiddz.dz15;

import android.content.Context;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;
import com.gmail.androiddz.domain.interaction.GetProfilesListSqlUseCase;
import com.gmail.androiddz.dz15.details.ProfileViewModel;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class Dz15ViewModel implements BaseViewModel {

    private Context context;
    private GetProfilesListSqlUseCase profilesListSqlUseCase = new GetProfilesListSqlUseCase();
    Dz15Adapter adapter = Dz15Adapter.getInstance();

    public Dz15ViewModel(Context context) {
        this.context = context;
    }

    @Override
    public void init() {
        profilesListSqlUseCase.execute(context, new DisposableObserver<ArrayList<ProfileDomainSql>>() {
            @Override
            public void onNext(@NonNull ArrayList<ProfileDomainSql> profileDomainSqls) {
                adapter.setDomainSqls(profileDomainSqls);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void release() {
    }

}
