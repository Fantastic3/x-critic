package fantastic3.xcritic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import fantastic3.xcritic.R;
import fantastic3.xcritic.activities.GamesActivity;
import fantastic3.xcritic.activities.MoviesActivity;
import fantastic3.xcritic.activities.MusicActivity;
import fantastic3.xcritic.activities.TvShowsActivity;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesSelectorFragment extends Fragment {
    View view;
    Button btnMovies;
    Button btnTvShows;
    Button btnMusic;
    Button btnGames;

    public static CategoriesSelectorFragment newInstance(Bundle args) {
        CategoriesSelectorFragment instance = new CategoriesSelectorFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.categories_selector_fragment, container, false);
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
        btnMovies = (Button) view.findViewById(R.id.btnMovies);
        btnTvShows = (Button) view.findViewById(R.id.btnTvShows);
        btnMusic = (Button) view.findViewById(R.id.btnMusic);
        btnGames = (Button) view.findViewById(R.id.btnGames);
    }

    private void setupListeners() {
        btnMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getText(R.string.lblMovies), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MoviesActivity.class));
            }
        });
        btnTvShows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getText(R.string.lblTvShows), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), TvShowsActivity.class));
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getText(R.string.lblMusic), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MusicActivity.class));
            }
        });
        btnGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getText(R.string.lblGames), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), GamesActivity.class));
            }
        });
    }
}
