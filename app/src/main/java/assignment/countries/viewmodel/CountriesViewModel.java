package assignment.countries.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import assignment.countries.service.model.CountryDetails;
import assignment.countries.service.network.NetworkManager;

/**
 * Created by AmirG on 08/11/2018.
 */

public class CountriesViewModel extends AndroidViewModel {

    private final LiveData<List<CountryDetails>> countriesObservable;

    public CountriesViewModel(Application application) {
        super(application);

        countriesObservable = NetworkManager.getInstance().getCountries();
    }

    public LiveData<List<CountryDetails>> getCountriesObservable() {
        return countriesObservable;
    }
}
