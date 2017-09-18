package com.gmail.androiddz.dz14;


import android.databinding.ObservableField;

import com.gmail.androiddz.domain.entity.CountryDomain;

public class Dz14ItemViewModel {

    public ObservableField<CountryDomain> country = new ObservableField<>();

    public Dz14ItemViewModel(CountryDomain country) {
        this.country.set(country);
    }

    public void setCountry(CountryDomain country) {
        this.country.set(country);
    }
}
