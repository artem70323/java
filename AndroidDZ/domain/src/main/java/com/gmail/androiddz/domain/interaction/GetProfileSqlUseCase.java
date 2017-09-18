package com.gmail.androiddz.domain.interaction;


import com.gmail.androiddz.data.database.DatabaseManager;
import com.gmail.androiddz.data.dbentity.Country;
import com.gmail.androiddz.data.dbentity.User;
import com.gmail.androiddz.domain.entity.CountryDomain;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;
import com.gmail.androiddz.domain.entity.ProfileIdSql;
import com.gmail.androiddz.domain.interaction.base.UseCase;


import io.reactivex.Observable;

public class GetProfileSqlUseCase extends UseCase<ProfileIdSql, ProfileDomainSql> {

    @Override
    protected Observable<ProfileDomainSql> buildUseCase(ProfileIdSql profileIdSql) {
        DatabaseManager manager = new DatabaseManager(profileIdSql.getContext());
        manager.open(false);
        User user = manager.getUserById(profileIdSql.getId());
        ProfileDomainSql domainSql;
        domainSql = convert(user, profileIdSql);
        manager.close();
        return Observable.just(domainSql);
    }

    private ProfileDomainSql convert(User user, ProfileIdSql profileIdSql) {
        ProfileDomainSql domainSql = new ProfileDomainSql();
        domainSql.setProfileId(profileIdSql);
        domainSql.setName(user.getName());
        domainSql.setAge(user.getAge());
        domainSql.setCountry(convertCountry(user.getCountry()));
        return domainSql;
    }

    private CountryDomain convertCountry(Country country) {
        CountryDomain countryDomain = new CountryDomain();
        countryDomain.setName(country.getName());
        countryDomain.setCode(country.getId());
        return countryDomain;
    }

}
