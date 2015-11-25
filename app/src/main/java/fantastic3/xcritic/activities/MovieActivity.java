package fantastic3.xcritic.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fantastic3.xcritic.R;
import fantastic3.xcritic.fragments.MovieFragment;
import fantastic3.xcritic.models.Movie;

/**
 * Created by jpodlech on 11/25/15.
 */
public class MovieActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        if (savedInstanceState == null) {
            setup();
        }
    }

    private void setup() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        setupMovie(ft);
        ft.commit();
    }

    private void setupMovie(FragmentTransaction ft) {
        Bundle bundle = new Bundle();
        Movie movie = getIntent().getExtras().getParcelable("movie");
        bundle.putParcelable("movie", movie);
        MovieFragment mf = MovieFragment.newInstance(bundle);
        ft.replace(R.id.flGeneric, mf);
    }
}
