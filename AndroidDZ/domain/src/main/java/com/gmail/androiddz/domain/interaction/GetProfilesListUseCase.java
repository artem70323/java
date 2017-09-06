package com.gmail.androiddz.domain.interaction;

import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.net.RestService;
import com.gmail.androiddz.domain.entity.ProfileDomain;
import com.gmail.androiddz.domain.entity.ProfileId;
import com.gmail.androiddz.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfilesListUseCase extends UseCase<ProfileId, List<ProfileDomain>> {

    @Override
    protected Observable<List<ProfileDomain>> buildUseCase(ProfileId param) {
        return RestService.getInstance().getProfiles()
                .map(new Function<List<ProfileData>, List<ProfileDomain>>() {
                    @Override
                    public List<ProfileDomain> apply(@NonNull List<ProfileData> profiles) throws Exception {
                        List<ProfileDomain> list = new ArrayList<>();
                        for(ProfileData profile: profiles) {
                            list.add(convert(profile));
                        }
                        return list;
                    }
                });
    }

    private ProfileDomain convert(ProfileData dataModel) {
        ProfileDomain profileDomain = new ProfileDomain();
        profileDomain.setName(dataModel.getName());
        profileDomain.setProfileId(new ProfileId(dataModel.getId()));
        return profileDomain;
    }

}
