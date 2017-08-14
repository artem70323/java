package com.gmail.test.domain.interaction.base;


public abstract class UseCase<OutParam> {

    protected abstract OutParam buildUseCase();

    public OutParam execute() {
        return buildUseCase();
    }

}
