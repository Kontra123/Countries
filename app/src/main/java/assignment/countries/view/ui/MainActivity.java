package assignment.countries.view.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.util.Log;

import assignment.countries.R;


public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            CountriesFragment countriesFragment = CountriesFragment.newInstance();
            openFragment(countriesFragment);
        }
    }

    public void showBorders(String country) {
        CountryBorderFragment countryBorderFragment = CountryBorderFragment.newInstance(country);
        openFragment(countryBorderFragment);
    }

    private void openFragment(LifecycleFragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.main_layout, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

}
