package com.gmail.androiddz.dz15.details;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.domain.entity.CountryDomain;
import com.gmail.androiddz.domain.interaction.LoadJsonUseCase;
import com.gmail.androiddz.dz14.SpinnerAdapter;

import java.util.ArrayList;

public class SpinnerViewModel implements BaseViewModel, AdapterView.OnItemSelectedListener {

    Activity activity;
    private ArrayList<CountryDomain> countries;
    public static CountryDomain countryDomain;
    SpinnerAdapter adapter;

    public SpinnerViewModel(Activity activity) {
        this.activity = activity;
        countries = new LoadJsonUseCase().execute(activity);
        adapter = new SpinnerAdapter(countries);
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void init() {
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        countryDomain = countries.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
