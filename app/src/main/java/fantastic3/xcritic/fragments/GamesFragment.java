package fantastic3.xcritic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import fantastic3.xcritic.R;
import fantastic3.xcritic.adapters.GamesAdapter;
import fantastic3.xcritic.clients.v2.metacritic.MetacriticGames;
import fantastic3.xcritic.models.Game;

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
        MetacriticGames.fetchBy("ps4", null, null, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                ArrayList<Game> games = Game.fromJSONResults(json);
                GamesAdapter adapter = new GamesAdapter(getContext(), games);
                lvGames.setAdapter(adapter);
            }
        });
        return view;
    }

    private void setup() {
        setupViews();
    }

    private void setupViews() {
        lvGames = (ListView) view.findViewById(R.id.lvGames);
    }
}
