package fantastic3.xcritic.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fantastic3.xcritic.R;
import fantastic3.xcritic.fragments.GameFragment;

/**
 * Created by jpodlech on 11/25/15.
 */
public class GameActivity extends AppCompatActivity {
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
        setupCategoriesSelector(ft);
        ft.commit();
    }

    private void setupCategoriesSelector(FragmentTransaction ft) {
        GameFragment mf = GameFragment.newInstance(null);
        ft.replace(R.id.flGeneric, mf);
    }
}
