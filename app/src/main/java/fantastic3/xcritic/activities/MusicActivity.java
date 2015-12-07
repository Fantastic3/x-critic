package fantastic3.xcritic.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import fantastic3.xcritic.R;
import fantastic3.xcritic.fragments.MusicFragment;
import fantastic3.xcritic.models.Music;

/**
 * Created by jpodlech on 11/25/15.
 */
public class MusicActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        if (savedInstanceState == null) {
            setup();
        }
    }

    private void setup() {
        setupMenu();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        setupMusic(ft);
        ft.commit();
    }

    private void setupMusic(FragmentTransaction ft) {
        Bundle bundle = new Bundle();
        Music music = getIntent().getExtras().getParcelable("music");
        bundle.putParcelable("music", music);
        MusicFragment mf = MusicFragment.newInstance(bundle);
        ft.replace(R.id.flGeneric, mf);
    }

    private void setupMenu() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
