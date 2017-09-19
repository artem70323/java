package com.gmail.androiddz.dz15.details;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.gmail.androiddz.base.BaseViewModel;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;
import com.gmail.androiddz.domain.entity.ProfileIdSql;
import com.gmail.androiddz.domain.interaction.AddUserToDatabaseUseCase;
import com.gmail.androiddz.domain.interaction.GetProfileSqlUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class ProfileViewModel implements BaseViewModel {
    private static final String TAG = ProfileViewModel.class.getSimpleName();
    private ProfileIdSql id = null;
    Context context;

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableField<String> country = new ObservableField<>("");

    public enum STATE {PROGRESS, DATA, ERROR, EDIT}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private GetProfileSqlUseCase profileSqlUseCase = new GetProfileSqlUseCase();
    private AddUserToDatabaseUseCase addUserToDatabaseUseCase = new AddUserToDatabaseUseCase();

    public ProfileViewModel(Context context) {
        this.context = context;
        state.set(STATE.EDIT);
    }

    public ProfileViewModel(int id, Context context) {
        this.id = new ProfileIdSql(id, context);
    }

    @Override
    public void init() {
        if (state.get() == STATE.PROGRESS) {
            profileSqlUseCase.execute(id, new DisposableObserver<ProfileDomainSql>() {
                @Override
                public void onNext(@NonNull ProfileDomainSql domainProfile) {
                    name.set(domainProfile.getName());
                    age.set(domainProfile.getAge());
                    country.set(domainProfile.getCountry().getName());
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
        ProfileDomainSql domainProfile = new ProfileDomainSql();
        domainProfile.setProfileId(new ProfileIdSql(0, context));
        domainProfile.setName(name.get());
        domainProfile.setAge(age.get());
        domainProfile.setCountry(SpinnerViewModel.countryDomain);
        addUserToDatabaseUseCase.execute(domainProfile, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
            }

            @Override
            public void onError( Throwable e) {
                state.set(STATE.ERROR);
            }

            @Override
            public void onComplete() {
                Toast.makeText(context, "Пользователь сохранён!", Toast.LENGTH_SHORT).show();
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
