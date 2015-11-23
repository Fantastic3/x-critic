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
//        // TODO: setup models and adapters
//        MetacriticMovies.fetchBy(null, null, null, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
//                Log.i("movies", json.toString());
//            }
//        });
        return view;
    }

    private void setup() {
        setupViews();
    }

    private void setupViews() {
        lvMovies = (ListView) view.findViewById(R.id.lvMovies);
    }
}
