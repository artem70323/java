package com.gmail.androiddz.dz11.details;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.EditText;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.domain.entity.ProfileDomain;
import com.gmail.androiddz.domain.entity.ProfileId;
import com.gmail.androiddz.domain.interaction.GetProfileUseCase;
import com.gmail.androiddz.domain.interaction.OverwriteProfileUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class ProfileViewModel implements BaseViewModel{
    private static final String TAG = ProfileViewModel.class.getSimpleName();
    private final ProfileId id;

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");;
    public ObservableInt age = new ObservableInt();

    public enum STATE {PROGRESS, DATA, ERROR, EDIT}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private GetProfileUseCase getProfileUseCase;
    private OverwriteProfileUseCase saveProfileUseCase = new OverwriteProfileUseCase();

    @Inject
    public ProfileViewModel(String id, GetProfileUseCase getProfileUseCase) {
        this.id = new ProfileId(id);
        this.getProfileUseCase = getProfileUseCase;
    }

    @Override
    public void init() {
        getProfileUseCase.execute(id, new DisposableObserver<ProfileDomain>() {
            @Override
            public void onNext(@NonNull ProfileDomain domainProfile) {
                name.set(domainProfile.getName());
                surname.set(domainProfile.getSurname());
                age.set(domainProfile.getAge());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                state.set(STATE.ERROR);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void release() {

    }

    public void saveProfile() {
        ProfileDomain domainProfile = new ProfileDomain();
        domainProfile.setProfileId(id);
        domainProfile.setName(name.get());
        domainProfile.setSurname(surname.get());
        domainProfile.setAge(age.get());
        saveProfileUseCase.execute(domainProfile, new DisposableObserver<ProfileData>() {
            @Override
            public void onNext(@NonNull ProfileData aVoid) {
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                state.set(STATE.ERROR);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @BindingAdapter("android:text")
    public static void setText(EditText view, int value) {
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static int getText(EditText view) {
        try {
            return Integer.valueOf(view.getText().toString());
        } catch (NumberFormatException e) {
            Log.e(TAG, "Wrong number format: " + e.getMessage());
            return 0;
        }

    }
}
