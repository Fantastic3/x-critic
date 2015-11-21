package fantastic3.xcritic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fantastic3.xcritic.R;

/**
 * Created by jpodlech on 11/21/15.
 */
public class CategoriesSelectorFragment extends Fragment {
    public static CategoriesSelectorFragment newInstance(Bundle args) {
        CategoriesSelectorFragment instance = new CategoriesSelectorFragment();
        if (args != null) instance.setArguments(args);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_selector_fragment, container, false);
        return view;
    }
}
