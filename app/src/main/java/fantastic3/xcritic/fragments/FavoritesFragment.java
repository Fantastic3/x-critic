package fantastic3.xcritic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import fantastic3.xcritic.R;

/**
 * Created by jpodlech on 12/7/15.
 */
public class FavoritesFragment extends Fragment {
    private View view;
    private RelativeLayout llFavorites;
    private Intent i;

    public static FavoritesFragment newInstance(Bundle args) {
        FavoritesFragment instance = new FavoritesFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorites, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    private void setup() {
    }
}
