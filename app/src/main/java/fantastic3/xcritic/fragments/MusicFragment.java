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
import fantastic3.xcritic.adapters.MusicsAdapter;
import fantastic3.xcritic.clients.v2.metacritic.MetacriticMusic;
import fantastic3.xcritic.models.Music;

/**
 * Created by jpodlech on 11/21/15.
 */
public class MusicFragment extends Fragment {
    private View view;
    private ListView lvMusics;

    public static MusicFragment newInstance(Bundle args) {
        MusicFragment instance = new MusicFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_music, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        MetacriticMusic.fetchBy(null, null, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                ArrayList<Music> musics = Music.fromJSONResults(json);
                MusicsAdapter adapter = new MusicsAdapter(getContext(), musics);
                lvMusics.setAdapter(adapter);
            }
        });
        return view;
    }

    private void setup() {
        setupViews();
    }

    private void setupViews() {
        lvMusics = (ListView) view.findViewById(R.id.lvMusic);
    }
}
