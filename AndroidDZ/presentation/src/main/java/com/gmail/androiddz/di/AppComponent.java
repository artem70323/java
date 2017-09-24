package com.gmail.androiddz.di;


import com.gmail.androiddz.dz11.Dz11Activity;
import com.gmail.androiddz.dz11.details.ProfileActivity;

import javax.inject.Singleton;

import dagger.Component;

//мост, начинающийся от @Inject
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    public void inject(Dz11Activity dz11Activity);
    public void inject(ProfileActivity profileActivity);

}
