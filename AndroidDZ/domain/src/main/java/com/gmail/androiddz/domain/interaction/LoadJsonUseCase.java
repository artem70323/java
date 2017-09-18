package com.gmail.androiddz.domain.interaction;


import android.app.Activity;

import com.gmail.androiddz.domain.entity.CountryDomain;
import com.gmail.androiddz.domain.interaction.base.UseCaseJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class LoadJsonUseCase implements UseCaseJson<Activity, CountryDomain> {

    @Override
    public ArrayList<CountryDomain> execute(Activity activity) {
        String json;
        try {
            InputStream is = activity.getAssets().open("countries.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        CountryDomain[] countries = new Gson().fromJson(json, CountryDomain[].class);
        return new ArrayList<>(Arrays.asList(countries));
    }

}
