package com.artyombash.presentation.base;

public abstract class BaseItemViewModel<Model> implements BaseViewModel {

    public abstract void setItem(Model item);

    @Override
    public void init() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }
}















