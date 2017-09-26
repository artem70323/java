package com.gmail.androiddz.domain.interaction;

import com.gmail.androiddz.domain.interaction.base.UseCase;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.net.RestService;
import com.gmail.androiddz.domain.entity.ProfileDomain;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class OverwriteProfileUseCase extends UseCase<ProfileDomain, ProfileData> {

    private RestService restService;

    @Inject
    public OverwriteProfileUseCase(RestService restService) {
        this.restService = restService;
    }

    @Override
    protected Observable<ProfileData> buildUseCase(ProfileDomain profileDomain) {
        return restService.overwriteProfile(convert(profileDomain));
    }

    private ProfileData convert(ProfileDomain profileDomain) {
        ProfileData profileData = new ProfileData();
        profileData.setName(profileDomain.getName());
        profileData.setSurname(profileDomain.getSurname());
        profileData.setAge(profileDomain.getAge());
        profileData.setId(profileDomain.getProfileId().getId());
        return profileData;
    }

}












