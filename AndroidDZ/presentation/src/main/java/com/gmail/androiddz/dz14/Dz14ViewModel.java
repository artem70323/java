package com.gmail.androiddz.dz14;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.domain.entity.CountryDomain;
import com.gmail.androiddz.domain.interaction.LoadJsonUseCase;

import java.util.ArrayList;

public class Dz14ViewModel implements BaseViewModel, AdapterView.OnItemSelectedListener {

    Activity activity;
    private static final String COUNTRIES = "COUNTRIES";
    private static final String COUNTRY_KEY = "KEY";
    public int countryListSelectedPosition = 0;
    private ArrayList<CountryDomain> countries;
    SpinnerAdapter adapter;
    SharedPreferences sPref;

    public Dz14ViewModel(Activity activity) {
        this.activity = activity;
        countries = new LoadJsonUseCase().execute(activity);
        adapter = new SpinnerAdapter(countries);
//        adapter.notifyDataSetChanged();

        sPref = activity.getSharedPreferences(COUNTRIES, Context.MODE_PRIVATE);
        String countryCode = sPref.getString(COUNTRY_KEY, null);
        countryListSelectedPosition = findCountryIndexByCode(countryCode);
    }

    @Override
    public void init() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
        sPref.edit()
                .putString(COUNTRY_KEY, countries.get(countryListSelectedPosition).getCode())
                .apply();
    }

    @Override
    public void release() {
    }

    public int findCountryIndexByCode(String code) {
        if (null == code) return 0;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        countryListSelectedPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
