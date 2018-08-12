package assignment.countries.view.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import assignment.countries.R;
import assignment.countries.databinding.CountryBorderLayoutBinding;
import assignment.countries.service.model.CountryDetails;
import assignment.countries.viewmodel.CountryBorderViewModel;

/**
 * Created by AmirG on 08/11/2018.
 */
public class CountryBorderFragment extends LifecycleFragment {

    private static final String COUNTRY_NAME_EXTRA = "country_name_extra";

    private CountryBorderLayoutBinding binding;

    public static CountryBorderFragment newInstance(String countryName) {
        CountryBorderFragment fragment = new CountryBorderFragment();
        Bundle bundle = new Bundle();
        bundle.putString(COUNTRY_NAME_EXTRA,countryName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.country_border_layout, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.setIsLoading(true);

        CountryBorderViewModel.Factory factory = new CountryBorderViewModel.Factory(getActivity().getApplication(), getArguments().getString(COUNTRY_NAME_EXTRA));

        CountryBorderViewModel countryBorderViewModel = ViewModelProviders.of(this, factory).get(CountryBorderViewModel.class);
        observeViewModel(countryBorderViewModel);
    }

    private void observeViewModel(CountryBorderViewModel viewModel) {

        viewModel.getCountryDetailsObservable().observe(this, new Observer<List<CountryDetails>>() {

            @Override
            public void onChanged(@Nullable List<CountryDetails> countryDetails) {

                if(countryDetails != null) {

                    binding.setIsLoading(false);

                    StringBuilder bordersStringBuilder = new StringBuilder();
                    for (CountryDetails item : countryDetails) {
                        bordersStringBuilder.append(item.borders);
                    }

                    binding.setBorder(bordersStringBuilder.toString());
                }
            }
        });
    }

}
