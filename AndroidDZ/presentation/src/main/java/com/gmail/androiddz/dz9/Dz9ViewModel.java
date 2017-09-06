package com.gmail.androiddz.dz9;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.domain.entity.UrlList;
import com.gmail.androiddz.domain.interaction.UrlUseCase;

public class Dz9ViewModel implements BaseViewModel {

    public String[] androidImageUrls;

    private UrlUseCase useCase = new UrlUseCase();

    @Override
    public void init() {
        UrlList urlList = useCase.execute();
        androidImageUrls = urlList.getAndroidImageUrls();
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

}
