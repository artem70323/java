package com.gmail.androiddz.domain.interaction;

import com.gmail.androiddz.data.database.DatabaseManager;
import com.gmail.androiddz.data.dbentity.Country;
import com.gmail.androiddz.data.dbentity.User;
import com.gmail.androiddz.domain.entity.CountryDomain;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;
import com.gmail.androiddz.domain.interaction.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;


public class AddUserToDatabaseUseCase extends UseCase<ProfileDomainSql, Void> {

    @Override
    protected Observable<Void> buildUseCase(final ProfileDomainSql profileDomainSql) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DatabaseManager manager = new DatabaseManager(profileDomainSql.getProfileId().getContext());
                manager.open(true);
                manager.insertUser(convert(profileDomainSql));
            }
        }).just(null);
    }

    private User convert(ProfileDomainSql domainSql) {
        User user = new User();
        user.setId(domainSql.getProfileId().getId());
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