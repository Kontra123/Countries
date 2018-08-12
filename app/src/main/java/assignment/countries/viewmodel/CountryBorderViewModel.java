package assignment.countries.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import java.util.List;

import assignment.countries.service.model.CountryDetails;
import assignment.countries.service.network.NetworkManager;

/**
 * Created by AmirG on 08/11/2018.
 */

public class CountryBorderViewModel extends AndroidViewModel {

    private final LiveData<List<CountryDetails>> countriesObservable;

    public CountryBorderViewModel(Application application, String country) {
        super(application);

        countriesObservable = NetworkManager.getInstance().getCountryDetails(country);
    }

    public LiveData<List<CountryDetails>> getCountryDetailsObservable() {
        return countriesObservable;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private final Application application;
        private final String country;

        public Factory(Application application, String country) {
            this.application = application;
            this.country = country;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new CountryBorderViewModel(application, country);
        }
    }
}
