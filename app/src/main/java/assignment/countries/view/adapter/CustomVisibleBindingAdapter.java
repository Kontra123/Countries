package assignment.countries.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by AmirG on 08/11/2018.
 */

public class CustomVisibleBindingAdapter {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
