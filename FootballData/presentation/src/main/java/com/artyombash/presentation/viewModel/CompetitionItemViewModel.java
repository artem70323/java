package com.artyombash.presentation.viewModel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.artyombash.domain.entity.Competition;
import com.artyombash.presentation.base.BaseItemViewModel;

public class CompetitionItemViewModel extends BaseItemViewModel<Competition> {

    public ObservableInt id = new ObservableInt();
    public ObservableField<String> caption = new ObservableField<>("");
    public ObservableField<String> league = new ObservableField<>("");
    public ObservableField<String> year = new ObservableField<>("");
    public ObservableField<Integer> currentMatchday = new ObservableField<>();
    public ObservableField<Integer> numberOfMatchdays = new ObservableField<>();
    public ObservableField<Integer> numberOfTeams = new ObservableField<>();
    public ObservableField<Integer> numberOfGames = new ObservableField<>();
    public ObservableField<String> lastUpdated = new ObservableField<>("");


    @Override
    public void setItem(Competition item) {
        id.set(item.getId());
        caption.set(item.getCaption());
        league.set(item.getLeague());
        year.set(item.getYear());
        currentMatchday.set(item.getCurrentMatchday());
        numberOfMatchdays.set(item.getNumberOfMatchdays());
        numberOfTeams.set(item.getNumberOfTeams());
        numberOfGames.set(item.getNumberOfGames());
        lastUpdated.set(item.getLastUpdated());
    }

}
