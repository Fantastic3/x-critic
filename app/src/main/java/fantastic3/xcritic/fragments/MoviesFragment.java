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

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import fantastic3.xcritic.R;
import fantastic3.xcritic.activities.MovieActivity;
import fantastic3.xcritic.adapters.MoviesAdapter;
import fantastic3.xcritic.clients.v2.metacritic.MetacriticMovies;
import fantastic3.xcritic.models.Movie;

/**
 * Created by jpodlech on 11/21/15.
 */
public class MoviesFragment extends Fragment {
    private View view;
    private ListView lvMovies;

    public static MoviesFragment newInstance(Bundle args) {
        MoviesFragment instance = new MoviesFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_movies, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        MetacriticMovies.fetchBy(null, null, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                ArrayList<Movie> movies = Movie.fromJSONResults(json);
                MoviesAdapter adapter = new MoviesAdapter(getContext(), movies);
                lvMovies.setAdapter(adapter);
                lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getActivity(), MovieActivity.class);
                        getActivity().startActivity(i);
                    }
                });
            }
        });
        return view;
    }

    private void setup() {
        setupViews();
    }

    private void setupViews() {
        lvMovies = (ListView) view.findViewById(R.id.lvMovies);
    }
}
