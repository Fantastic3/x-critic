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
import fantastic3.xcritic.models.Music;

/**
 * Created by jpodlech on 11/25/15.
 */
public class MusicFragment extends Fragment {
    private View view;
    private Music music;
    private ImageView ivThumbnail;
    private TextView tvName;
    private TextView tvAuthor;
    private TextView tvReleaseDate;
    private TextView tvScore;
    private TextView tvUrl;
    private TextView tvUserScore;
    private TextView tvGenre;

    public static MusicFragment newInstance(Bundle args) {
        MusicFragment instance = new MusicFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_music, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    private void setup() {
        setupMusic();
        setupViews();
        setupContent();
    }

    private void setupMusic() {
        music = getArguments().getParcelable("music");
    }

    private void setupViews() {
        ivThumbnail = (ImageView) view.findViewById(R.id.ivThumbnail);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        tvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);
        tvScore = (TextView) view.findViewById(R.id.tvScore);
        tvUrl = (TextView) view.findViewById(R.id.tvUrl);
        tvUserScore = (TextView) view.findViewById(R.id.tvUserScore);
        tvGenre = (TextView) view.findViewById(R.id.tvGenre);
    }

    private void setupContent() {
        Picasso.with(getContext()).load(music.getThumbnail()).resize(250, 250).into(ivThumbnail);
        tvName.setText(music.getName());
        tvAuthor.setText(music.getAuthor());
        tvReleaseDate.setText(music.getReleaseDate());
        tvScore.setText(music.getScore());
        tvUrl.setText(music.getUrl());
        tvUserScore.setText(music.getUserScore());
        tvGenre.setText(music.getGenre());
    }
}
