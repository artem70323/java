package com.gmail.androiddz.dz11;

import android.databinding.ObservableField;
import android.util.Log;

import com.gmail.androiddz.base.BaseItemViewModel;
import com.gmail.androiddz.domain.entity.ProfileDomain;
import com.gmail.androiddz.domain.entity.ProfileId;

public class ProfileItemViewModel extends BaseItemViewModel<ProfileDomain> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<ProfileId> id = new ObservableField<>();

    @Override
    public void setItem(ProfileDomain item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
        id.set(item.getProfileId());
        Log.e("AAA", id.get().getId());
    }
}
