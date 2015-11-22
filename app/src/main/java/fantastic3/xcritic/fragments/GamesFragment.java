package fantastic3.xcritic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fantastic3.xcritic.R;

/**
 * Created by jpodlech on 11/21/15.
 */
public class GamesFragment extends Fragment {
    private View view;
    private ListView lvGames;

    public static GamesFragment newInstance(Bundle args) {
        GamesFragment instance = new GamesFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_games, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    private void setup() {
        setupViews();
    }

    private void setupViews() {
        lvGames = (ListView) view.findViewById(R.id.lvGames);
    }
}
