package assignment.countries.view.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import assignment.countries.R;
import assignment.countries.service.model.CountryDetails;
import assignment.countries.databinding.CountriesLayoutBinding;
import assignment.countries.view.adapter.CountriesAdapter;
import assignment.countries.view.callback.CountryClickCallback;
import assignment.countries.viewmodel.CountriesViewModel;

/**
 * Created by AmirG on 08/11/2018.
 */

public class CountriesFragment extends LifecycleFragment{

    private CountriesLayoutBinding binding;
    private CountriesAdapter countriesAdapter;

    public static CountriesFragment newInstance() {
        CountriesFragment fragment = new CountriesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.countries_layout, container, false);
        countriesAdapter = new CountriesAdapter(countryClickCallback);
        binding.countriesList.setAdapter(countriesAdapter);

        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final CountriesViewModel viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);

        observeCountriesViewModel(viewModel);
    }

    private void observeCountriesViewModel(CountriesViewModel viewModel) {
        LiveData<List<CountryDetails>> countriesObservable = viewModel.getCountriesObservable();
        countriesObservable.observe(this, new Observer<List<CountryDetails>>() {

            @Override
            public void onChanged(@Nullable List<CountryDetails> countryDetails) {

                binding.setIsLoading(false);

                List<String> countriesArray = new ArrayList<String>();

                for (CountryDetails item : countryDetails) {
                    countriesArray.add(item.name);
                }

                if(countryDetails != null) {
                    countriesAdapter.setItems(countriesArray);
                }
            }
        });
    }

    private final CountryClickCallback countryClickCallback = new CountryClickCallback() {

        @Override
        public void onClick(String country) {
            if(getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((MainActivity)getActivity()).showBorders(country);
            }
        }
    };

}
