package fantastic3.xcritic.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fantastic3.xcritic.R;
import fantastic3.xcritic.fragments.CategoriesSelectorFragment;

/**
 * Created by jpodlech on 11/20/15.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
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
        CategoriesSelectorFragment csf = CategoriesSelectorFragment.newInstance(null);
        ft.replace(R.id.flCategoriesSelector, csf);
    }
}
