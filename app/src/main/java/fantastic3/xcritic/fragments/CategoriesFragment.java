package fantastic3.xcritic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import fantastic3.xcritic.R;
import fantastic3.xcritic.adapters.CategoriesFragmentPagerAdapter;

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
    private CategoriesFragmentPagerAdapter adapter;
    private static Integer selectedTabId;

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupTab();
    }

    private void setup() {
        setupIntent();
        setupViews();
        setupAdapters();
        setupListeners();
        setupTab();
    }

    private void setupIntent() {
        i = getActivity().getIntent();
    }

    private void setupViews() {
        pager = (ViewPager) view.findViewById(R.id.pager);
        tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabsStrip.setTextColorResource(R.color.colorWhite);
    }

    private void setupAdapters() {
        adapter = new CategoriesFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabsStrip.setViewPager(pager);
    }

    private void setupListeners() {
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                selectedTabId = position;
                setTabBackground(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setupTab() {
        Integer previousTabId = (selectedTabId == null) ? DEFAULT_TAB_ID: selectedTabId;
        selectedTabId = i.getIntExtra(
                ID_TAB_ID,
                previousTabId
        );
        pager.setCurrentItem(selectedTabId);
        setTabBackground(selectedTabId);
    }

    private void setTabBackground(Integer position) {
        switch(position) {
            case 0:
                tabsStrip.setBackgroundColor(getResources().getColor(R.color.colorMovies));
                break;
            case 1:
                tabsStrip.setBackgroundColor(getResources().getColor(R.color.colorMusic));
                break;
            case 2:
                tabsStrip.setBackgroundColor(getResources().getColor(R.color.colorGames));
                break;
        }
    }

    public void onQueryTextSubmit(String query) {
        switch(selectedTabId) {
            case 1:
                ((MusicsFragment) adapter.getItem(selectedTabId)).onQueryTextSubmit(query);
                break;
            case 2:
                ((GamesFragment) adapter.getItem(selectedTabId)).onQueryTextSubmit(query);
                break;
            case 0:
            default:
                ((MoviesFragment) adapter.getItem(selectedTabId)).onQueryTextSubmit(query);
                break;
        }
    }
}
