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
import fantastic3.xcritic.models.Game;

/**
 * Created by jpodlech on 11/25/15.
 */
public class GameFragment extends Fragment {
    private View view;
    private Game game;
    private ImageView ivThumbnail;
    private TextView tvName;
    private TextView tvReleaseDate;
    private TextView tvRating;
    private TextView tvScore;
    private TextView tvUrl;

    public static GameFragment newInstance(Bundle args) {
        GameFragment instance = new GameFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_game, container, false);
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
        game = getArguments().getParcelable("game");
    }

    private void setupViews() {
        ivThumbnail = (ImageView) view.findViewById(R.id.ivThumbnail);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);
        tvRating = (TextView) view.findViewById(R.id.tvRating);
        tvScore = (TextView) view.findViewById(R.id.tvScore);
        tvUrl = (TextView) view.findViewById(R.id.tvUrl);
    }

    private void setupContent() {
        Picasso.with(getContext()).load(game.getThumbnail()).resize(250, 250).into(ivThumbnail);
        tvName.setText(game.getName());
        tvReleaseDate.setText(game.getReleaseDate());
        tvRating.setText(game.getRating());
        tvScore.setText(game.getScore());
        //tvUrl.setText(game.getUrl());
    }
}
