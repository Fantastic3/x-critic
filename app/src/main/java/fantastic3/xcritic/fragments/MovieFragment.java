package fantastic3.xcritic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fantastic3.xcritic.R;
import fantastic3.xcritic.models.Movie;

/**
 * Created by jpodlech on 11/25/15.
 */
public class MovieFragment extends Fragment {
    private View view;
    private Movie movie;
    private ImageView ivThumbnail;
    private TextView tvName;
    private TextView tvAuthor;
    private TextView tvReleaseDate;
    private TextView tvRating;
    private TextView tvCast;
    private TextView tvGenre;
    private TextView tvScore;
    private TextView tvUserScore;
    private TextView tvRuntime;
    private TextView tvUrl;

    public static MovieFragment newInstance(Bundle args) {
        MovieFragment instance = new MovieFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    private void setup() {
        setupGame();
        setupViews();
        setupContent();
    }

    private void setupGame() {
        movie = getArguments().getParcelable("movie");
    }

    private void setupViews() {
        ivThumbnail = (ImageView) view.findViewById(R.id.ivThumbnail);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);
        tvRating = (TextView) view.findViewById(R.id.tvRating);
        tvScore = (TextView) view.findViewById(R.id.tvScore);
        tvUserScore = (TextView) view.findViewById(R.id.tvUserScore);
        tvUrl = (TextView) view.findViewById(R.id.tvUrl);
        tvCast = (TextView) view.findViewById(R.id.tvCast);
        tvGenre = (TextView) view.findViewById(R.id.tvGenre);
        tvRuntime = (TextView) view.findViewById(R.id.tvRuntime);
    }

    private void setupContent() {
        Picasso.with(getContext()).load(movie.getThumbnail()).into(ivThumbnail);
        tvName.setText(movie.getName());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvRating.setText(movie.getRating());
        tvScore.setText(movie.getScore());
        tvUrl.setText(movie.getUrl());
        tvCast.setText(movie.getCast());
        tvGenre.setText(movie.getGenre());
        tvRuntime.setText(movie.getRuntime());
    }
}
