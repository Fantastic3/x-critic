package fantastic3.xcritic.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import fantastic3.xcritic.R;
import fantastic3.xcritic.fragments.CategoriesFragment;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

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
        CategoriesFragment cf = CategoriesFragment.newInstance(null);
        ft.replace(R.id.flCategories, cf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categories, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void onFavorites(MenuItem item) {
    }
}
