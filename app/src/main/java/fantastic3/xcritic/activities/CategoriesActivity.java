package fantastic3.xcritic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;

import fantastic3.xcritic.R;
import fantastic3.xcritic.adapters.FragmentPagerAdapter;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesActivity extends AppCompatActivity {
    public static final String ID_TAB_ID = "tab_id";
    public static final String ID_MOVIES = "movies";
    public static final String ID_TV_SHOWS = "tv_shows";
    public static final String ID_MUSIC = "music";
    public static final String ID_GAMES = "games";
    private static final Integer DEFAULT_TAB_ID = 0;

    private ViewPager viewPager;
    private PagerSlidingTabStrip tabsStrip;
    private Intent i;
    private Integer selectedTabId;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        if (savedInstanceState == null) {
            setup();
        }
    }

    public void setup() {
        setupIntent();
        setupViews();
        setupAdapters();
        setupTab();
    }

    public void setupIntent() {
        i = getIntent();
    }

    public void setupViews() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
    }

    public void setupAdapters() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()));
        tabsStrip.setViewPager(viewPager);
    }

    public void setupTab() {
        selectedTabId = i.getIntExtra(
                CategoriesActivity.ID_TAB_ID,
                DEFAULT_TAB_ID
        );
        viewPager.setCurrentItem(selectedTabId);
    }
}
