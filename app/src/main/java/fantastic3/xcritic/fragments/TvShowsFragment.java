package fantastic3.xcritic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fantastic3.xcritic.R;

/**
 * Created by jpodlech on 11/21/15.
 */
public class TvShowsFragment extends Fragment {
    private View view;

    public static TvShowsFragment newInstance(Bundle args) {
        TvShowsFragment instance = new TvShowsFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_tv_shows, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    private void setup() {

    }
}
