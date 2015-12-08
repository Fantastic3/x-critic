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

import java.util.ArrayList;
import java.util.List;

import fantastic3.xcritic.R;
import fantastic3.xcritic.activities.MovieActivity;
import fantastic3.xcritic.adapters.ListItemAdapter;
import fantastic3.xcritic.clients.v2.metacritic.ServiceGenerator;
import fantastic3.xcritic.clients.v2.metacritic.movies.MoviesClient;
import fantastic3.xcritic.clients.v2.metacritic.movies.NewReleasesResult;
import fantastic3.xcritic.interfaces.ListItemable;
import fantastic3.xcritic.models.Movie;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by jpodlech on 11/21/15.
 */
public class MoviesFragment extends Fragment {
    private View view;
    private ListView lvMovies;
    private List<ListItemable> items;

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
        MoviesClient moviesClient = ServiceGenerator.build(getContext().getCacheDir()).createService(MoviesClient.class);
        moviesClient.newReleases(null).enqueue(new Callback<NewReleasesResult>() {
            @Override
            public void onResponse(Response<NewReleasesResult> response, Retrofit retrofit) {
                items = new ArrayList<ListItemable>();
                items.addAll(response.body().getResults());
                ListItemAdapter adapter = new ListItemAdapter(getContext(), items);
                lvMovies.setAdapter(adapter);
                lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(getActivity(), MovieActivity.class);
                        i.putExtra("movie", (Movie) items.get(position));
                        getActivity().startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {

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

    public void onQueryTextSubmit(String query) {

    }
}
