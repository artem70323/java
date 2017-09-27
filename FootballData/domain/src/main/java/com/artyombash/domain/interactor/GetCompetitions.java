package com.artyombash.domain.interactor;


import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.executor.PostExecutionThread;
import com.artyombash.domain.executor.ThreadExecutor;
import com.artyombash.domain.repository.FootballRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Competition}.
 */
public class GetCompetitions extends UseCase<Void, List<Competition>> {

    private final FootballRepository repository;

    @Inject
    public GetCompetitions(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           FootballRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<List<Competition>> buildUseCase(Void aVoid) {
        return repository.competitions();
    }

}
