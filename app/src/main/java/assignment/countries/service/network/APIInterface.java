package assignment.countries.service.network;

import java.util.List;

import assignment.countries.service.model.CountryDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by AmirG on 08/11/2018.
 */

public interface APIInterface {

    @GET("/rest/v2/all/")
    Call<List<CountryDetails>> getAllCountries();

    @GET("/rest/v2/name/{country}")
    Call<List<CountryDetails>> getCountryDetails(@Path("country") String country);

}
