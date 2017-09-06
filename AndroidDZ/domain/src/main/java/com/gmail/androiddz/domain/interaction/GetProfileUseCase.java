package com.gmail.androiddz.domain.interaction;

import com.gmail.androiddz.domain.interaction.base.UseCase;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.net.RestService;
import com.gmail.androiddz.domain.entity.ProfileDomain;
import com.gmail.androiddz.domain.entity.ProfileId;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfileUseCase extends UseCase<ProfileId, ProfileDomain> {

    @Override
    protected Observable<ProfileDomain> buildUseCase(ProfileId profileId) {
        return RestService.getInstance().getProfile(profileId.getId())
                .map(new Function<ProfileData, ProfileDomain>() {
                    @Override
                    public ProfileDomain apply(@NonNull ProfileData profileData) throws Exception {
                        return convert(profileData);
                    }
                });
    }

    private ProfileDomain convert(ProfileData dataModel) {
        ProfileDomain profileDomain = new ProfileDomain();
        profileDomain.setName(dataModel.getName());
        profileDomain.setSurname(dataModel.getSurname());
        profileDomain.setAge(dataModel.getAge());
        profileDomain.setProfileId(new ProfileId(dataModel.getId()));
        return profileDomain;
    }

}
