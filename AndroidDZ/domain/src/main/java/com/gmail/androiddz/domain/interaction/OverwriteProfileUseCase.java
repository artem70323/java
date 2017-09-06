package com.gmail.androiddz.domain.interaction;

import com.gmail.androiddz.domain.interaction.base.UseCase;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.net.RestService;
import com.gmail.androiddz.domain.entity.ProfileDomain;

import io.reactivex.Observable;

public class OverwriteProfileUseCase extends UseCase<ProfileDomain, ProfileData> {


    @Override
    protected Observable<ProfileData> buildUseCase(ProfileDomain profileDomain) {
        return RestService.getInstance().overwriteProfile(convert(profileDomain));
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












