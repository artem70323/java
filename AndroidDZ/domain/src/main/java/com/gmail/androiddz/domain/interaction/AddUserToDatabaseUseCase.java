package com.gmail.androiddz.domain.interaction;


import com.gmail.androiddz.data.database.DatabaseManager;
import com.gmail.androiddz.data.dbentity.Country;
import com.gmail.androiddz.data.dbentity.User;
import com.gmail.androiddz.domain.entity.CountryDomain;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;
import com.gmail.androiddz.domain.interaction.base.UseCase;

import io.reactivex.Completable;
import io.reactivex.Observable;


public class AddUserToDatabaseUseCase extends UseCase<ProfileDomainSql, Void> {

    @Override
    protected Observable<Void> buildUseCase(final ProfileDomainSql profileDomainSql) {

        DatabaseManager manager = new DatabaseManager(profileDomainSql.getProfileId().getContext());
        manager.open(true);
        manager.insertUser(convert(profileDomainSql));
        manager.close();
        return Completable.complete().toObservable();

//        return Observable.create(new ObservableOnSubscribe<Void>() {
//            @Override
//            public void subscribe(ObservableEmitter<Void> e) throws Exception {
//                DatabaseManager manager = new DatabaseManager(profileDomainSql.getProfileId().getContext());
//                manager.open(true);
//                manager.insertUser(convert(profileDomainSql));
//                Log.e("manager.insertUser", "convert(profileDomainSql)");
//                manager.close();
//            }
//        }).just(null);
//        Log.e("AddUserToDatabaseUse", "AddUserToDatabaseUse");
//        return Completable.complete().toObservable();
    }

    private User convert(ProfileDomainSql domainSql) {
        User user = new User();
        user.setName(domainSql.getName());
        user.setAge(domainSql.getAge());
        user.setCountry(convertCountry(domainSql.getCountry()));
        return user;
    }

    private Country convertCountry(CountryDomain countryDomain) {
        Country country = new Country();
        country.setId(countryDomain.getCode());
        country.setName(countryDomain.getName());
        return country;
    }

}