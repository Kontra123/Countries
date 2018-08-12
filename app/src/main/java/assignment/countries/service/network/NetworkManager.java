package assignment.countries.service.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import assignment.countries.service.model.CountryDetails;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AmirG on 08/11/2018.
 */
public class NetworkManager {

    private APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);;

    public static synchronized NetworkManager getInstance()
    {
        return SingeltonHolder.NETWORK_MANAGER;
    }

    private static class SingeltonHolder
    {
        private static final NetworkManager NETWORK_MANAGER = new NetworkManager();
    }

    public LiveData<List<CountryDetails>> getCountries() {

        final MutableLiveData<List<CountryDetails>> data = new MutableLiveData<List<CountryDetails>>();
        Call<List<CountryDetails>> call = apiInterface.getAllCountries();

        call.enqueue(new Callback<List<CountryDetails>>() {

            @Override
            public void onResponse(Call<List<CountryDetails>> call, Response<List<CountryDetails>> response) {

                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryDetails>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    public LiveData<List<CountryDetails>> getCountryDetails(String countryName) {

        final MutableLiveData<List<CountryDetails>> data = new MutableLiveData<List<CountryDetails>>();

        Call<List<CountryDetails>> call = apiInterface.getCountryDetails(countryName);
        call.enqueue(new Callback<List<CountryDetails>>() {

            @Override
            public void onResponse(Call<List<CountryDetails>> call, Response<List<CountryDetails>> response) {

                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryDetails>> call, Throwable t) {

                data.setValue(null);
            }
        });

        return data;
    }

}
