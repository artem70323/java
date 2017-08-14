package com.gmail.androiddz.dz9;


import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.test.domain.entity.UrlList;
import com.gmail.test.domain.interaction.UrlUseCase;

public class Dz9ViewModel implements BaseViewModel {

    public String[] android_image_urls;

    private UrlUseCase useCase = new UrlUseCase();

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        UrlList profile = useCase.execute();
        android_image_urls = profile.getAndroid_image_urls();
    }

    @Override
    public void pause() {
    }

}
