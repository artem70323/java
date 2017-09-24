package com.gmail.androiddz.domain.interaction;


import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.repository.UsersRepository;
import com.gmail.androiddz.domain.entity.ProfileDomain;
import com.gmail.androiddz.domain.entity.ProfileId;
import com.gmail.androiddz.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfilesListUseCase extends UseCase<Void, List<ProfileDomain>> {

    UsersRepository repository;

    @Inject
    public GetProfilesListUseCase(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<List<ProfileDomain>> buildUseCase(Void aVoid) {
        return repository.getProfiles()
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



//
//public class GetProfilesListUseCase extends UseCase<Context, List<ProfileDomain>> {
//
//    @Override
//    protected Observable<List<ProfileDomain>> buildUseCase(Context context) {
//        if (hasConnection(context)) {
//            return cloudUsers();
//        }
//        return null;
//    }
//
//    public boolean hasConnection(final Context context) {
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        if (activeNetwork != null) { // connected to the internet
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                return true;
//            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private Observable<List<ProfileDomain>> cloudUsers() {
//        return RestService.getInstance().getProfiles()
//                .map(new Function<List<ProfileData>, List<ProfileDomain>>() {
//                    @Override
//                    public List<ProfileDomain> apply(@NonNull List<ProfileData> profiles) throws Exception {
//                        List<ProfileDomain> list = new ArrayList<>();
//                        for (ProfileData profile : profiles) {
//                            list.add(convert(profile));
//                        }
//                        return list;
//                    }
//                });
//    }
