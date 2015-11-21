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
import fantastic3.xcritic.activities.CategoriesActivity;
import fantastic3.xcritic.adapters.FragmentPagerAdapter;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesSelectorFragment extends Fragment {
    View view;
    RelativeLayout llMovies;
    RelativeLayout llTvShows;
    RelativeLayout llMusic;
    RelativeLayout llGames;

    public static CategoriesSelectorFragment newInstance(Bundle args) {
        CategoriesSelectorFragment instance = new CategoriesSelectorFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories_selector, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    private void setup() {
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        llMovies = (RelativeLayout) view.findViewById(R.id.llMovies);
        llTvShows = (RelativeLayout) view.findViewById(R.id.llTvShows);
        llMusic = (RelativeLayout) view.findViewById(R.id.llMusic);
        llGames = (RelativeLayout) view.findViewById(R.id.llGames);
    }

    private void setupListeners() {
        final Intent i = new Intent(getActivity(), CategoriesActivity.class);
        llMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra(
                        CategoriesActivity.ID_TAB_ID,
                        FragmentPagerAdapter.tabKeys.indexOf(CategoriesActivity.ID_MOVIES)
                );
                startActivity(i);
            }
        });
        llTvShows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra(
                        CategoriesActivity.ID_TAB_ID,
                        FragmentPagerAdapter.tabKeys.indexOf(CategoriesActivity.ID_TV_SHOWS)
                );
                startActivity(i);
            }
        });
        llMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra(
                        CategoriesActivity.ID_TAB_ID,
                        FragmentPagerAdapter.tabKeys.indexOf(CategoriesActivity.ID_MUSIC)
                );
                startActivity(i);
            }
        });
        llGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra(
                        CategoriesActivity.ID_TAB_ID,
                        FragmentPagerAdapter.tabKeys.indexOf(CategoriesActivity.ID_GAMES)
                );
                startActivity(i);
            }
        });
    }
}
