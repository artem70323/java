package com.gmail.androiddz.domain.interaction;

import android.content.Context;

import com.gmail.androiddz.data.database.DatabaseManager;
import com.gmail.androiddz.data.dbentity.User;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;
import com.gmail.androiddz.domain.entity.ProfileIdSql;
import com.gmail.androiddz.domain.interaction.base.UseCase;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetProfilesListSqlUseCase extends UseCase<Context, ArrayList<ProfileDomainSql>> {

    @Override
    protected Observable<ArrayList<ProfileDomainSql>> buildUseCase(final Context context) {
        DatabaseManager manager = new DatabaseManager(context);
        manager.open(false);
        ArrayList<User> list = manager.getUsers();
        ArrayList<ProfileDomainSql> domainSqls = new ArrayList<>();
        for (User user : list) {
            ProfileDomainSql domainSql = convert(user, context);
            domainSqls.add(domainSql);
            manager.close();
        }
        return Observable.just(domainSqls);
    }

    private ProfileDomainSql convert(User user, Context context) {
        ProfileDomainSql domainSql = new ProfileDomainSql();
        domainSql.setProfileId(new ProfileIdSql(user.getId(), context));
        domainSql.setName(user.getName());
        return domainSql;
    }

}
