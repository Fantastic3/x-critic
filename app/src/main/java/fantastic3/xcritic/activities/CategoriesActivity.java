package fantastic3.xcritic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
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
        setupMenu();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        setupCategoriesSelector(ft);
        ft.commit();
    }

    private void setupCategoriesSelector(FragmentTransaction ft) {
        CategoriesFragment cf = CategoriesFragment.newInstance(null);
        ft.replace(R.id.flCategories, cf);
    }

    private void setupMenu() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categories, menu);
        MenuItem miSearch = menu.findItem(R.id.miSearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(miSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO: search movies, musics or games.
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void onFavorites(MenuItem item) {
        Intent i = new Intent(this, FavoritesActivity.class);
        startActivity(i);
    }
}
