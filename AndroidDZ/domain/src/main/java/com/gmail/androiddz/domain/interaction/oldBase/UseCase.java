package com.gmail.androiddz.domain.interaction.oldBase;


public abstract class UseCase<OutParam> {

    protected abstract OutParam buildUseCase();

    public OutParam execute() {
        return buildUseCase();
    }

}
