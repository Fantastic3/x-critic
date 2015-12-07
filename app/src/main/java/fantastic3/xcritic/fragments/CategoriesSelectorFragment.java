package fantastic3.xcritic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import fantastic3.xcritic.R;
import fantastic3.xcritic.XcriticApplication;
import fantastic3.xcritic.activities.CategoriesActivity;
import fantastic3.xcritic.adapters.CategoriesFragmentPagerAdapter;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesSelectorFragment extends Fragment {
    private View view;
    private RelativeLayout llMovies;
    private RelativeLayout llTvShows;
    private RelativeLayout llMusic;
    private RelativeLayout llGames;
    private Intent i;

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
        i = new Intent(getActivity(), CategoriesActivity.class);
        llMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForCategory(CategoriesFragment.ID_MOVIES);
            }
        });
        llTvShows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        XcriticApplication.getContext(),
                        XcriticApplication.getContext().getText(R.string.lblComingSoon).toString(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        llMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForCategory(CategoriesFragment.ID_MUSIC);
            }
        });
        llGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForCategory(CategoriesFragment.ID_GAMES);
            }
        });
    }

    private void startActivityForCategory(String key) {
        i.putExtra(
                CategoriesFragment.ID_TAB_ID,
                CategoriesFragmentPagerAdapter.tabKeys.indexOf(key)
        );
        startActivity(i);
    }
}
