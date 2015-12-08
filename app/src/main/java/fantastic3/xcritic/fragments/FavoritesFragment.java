package fantastic3.xcritic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import fantastic3.xcritic.R;
import fantastic3.xcritic.XcriticApplication;
import fantastic3.xcritic.activities.GameActivity;
import fantastic3.xcritic.activities.MovieActivity;
import fantastic3.xcritic.activities.MusicActivity;
import fantastic3.xcritic.adapters.FavoriteAdapter;
import fantastic3.xcritic.interfaces.ListItemable;
import fantastic3.xcritic.models.Game;
import fantastic3.xcritic.models.Movie;
import fantastic3.xcritic.models.Music;

/**
 * Created by jpodlech on 12/7/15.
 */
public class FavoritesFragment extends Fragment {
    private View view;
    private ListView lvFavorites;

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
        setupViews();
        setupAdapter();
        setupListeners();
    }

    private void setupViews() {
        lvFavorites = (ListView) view.findViewById(R.id.lvFavorites);
    }

    private void setupAdapter() {
        FavoriteAdapter adapter = new FavoriteAdapter(getContext(), XcriticApplication.getFavorites());
        lvFavorites.setAdapter(adapter);
    }

    private void setupListeners() {
        lvFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItemable item = XcriticApplication.getFavorites().get(position);
                Intent i;
                if (item instanceof Game) {
                    i = new Intent(getActivity(), GameActivity.class);
                    i.putExtra("game", (Game) item);
                    getActivity().startActivity(i);
                }
                if (item instanceof Movie) {
                    i = new Intent(getActivity(), MovieActivity.class);
                    i.putExtra("movie", (Movie) item);
                    getActivity().startActivity(i);
                }
                if (item instanceof Music) {
                    i = new Intent(getActivity(), MusicActivity.class);
                    i.putExtra("music", (Music) item);
                    getActivity().startActivity(i);
                }
            }
        });
    }
}
