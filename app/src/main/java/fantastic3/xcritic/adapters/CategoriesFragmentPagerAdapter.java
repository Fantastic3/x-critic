package fantastic3.xcritic.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import fantastic3.xcritic.fragments.GamesFragment;
import fantastic3.xcritic.fragments.MoviesFragment;
import fantastic3.xcritic.fragments.MusicFragment;
import fantastic3.xcritic.fragments.TvShowsFragment;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesFragmentPagerAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT = 4;
    public static final ArrayList<String> tabKeys = new ArrayList<>(Arrays.asList("movies", "tv_shows", "music", "games" ));
    public static final String tabTitles[] = new String[] { "Movies", "TV Shows", "Music", "Games" };

    public CategoriesFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = MoviesFragment.newInstance(null);
                break;
            case 1:
                fragment = TvShowsFragment.newInstance(null);
                break;
            case 2:
                fragment = MusicFragment.newInstance(null);
                break;
            case 3:
                fragment = GamesFragment.newInstance(null);
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
