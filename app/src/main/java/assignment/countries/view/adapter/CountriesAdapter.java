package assignment.countries.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import assignment.countries.R;
import assignment.countries.databinding.RowCountryLayoutBinding;
import assignment.countries.view.callback.CountryClickCallback;

/**
 * Created by AmirG on 08/11/2018.
 */
public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private final CountryClickCallback countryClickCallback;
    private List<String> items = new ArrayList<String>();

    public CountriesAdapter(CountryClickCallback clickCallback) {
        countryClickCallback = clickCallback;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final RowCountryLayoutBinding binding;

        public ViewHolder(RowCountryLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RowCountryLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_country_layout, parent, false);
        binding.setCallback(countryClickCallback);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = items.get(position);
        holder.binding.setCountry(name);
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<String> items) {
        this.items = items;
        notifyDataSetChanged();

    }

}
