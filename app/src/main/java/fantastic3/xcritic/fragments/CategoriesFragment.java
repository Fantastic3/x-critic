package fantastic3.xcritic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import fantastic3.xcritic.R;
import fantastic3.xcritic.adapters.FragmentPagerAdapter;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesFragment extends Fragment {
    public static final String ID_TAB_ID = "tab_id";
    public static final String ID_MOVIES = "movies";
    public static final String ID_TV_SHOWS = "tv_shows";
    public static final String ID_MUSIC = "music";
    public static final String ID_GAMES = "games";
    private static final Integer DEFAULT_TAB_ID = 0;

    private View view;
    private ViewPager pager;
    private PagerSlidingTabStrip tabsStrip;
    private Intent i;
    private Integer selectedTabId;

    public static CategoriesFragment newInstance(Bundle args) {
        CategoriesFragment instance = new CategoriesFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);
        if (savedInstanceState == null) {
            setup();
        }
        return view;
    }

    public void setup() {
        setupIntent();
        setupViews();
        setupAdapters();
        setupTab();
    }

    public void setupIntent() {
        i = getActivity().getIntent();
    }

    public void setupViews() {
        pager = (ViewPager) view.findViewById(R.id.pager);
        tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
    }

    public void setupAdapters() {
        pager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()));
        tabsStrip.setViewPager(pager);
    }

    public void setupTab() {
        selectedTabId = i.getIntExtra(
                ID_TAB_ID,
                DEFAULT_TAB_ID
        );
        pager.setCurrentItem(selectedTabId);
    }
}
