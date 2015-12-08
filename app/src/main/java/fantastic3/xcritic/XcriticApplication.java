package fantastic3.xcritic;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import fantastic3.xcritic.interfaces.ListItemable;

/**
 * Created by jpodlech on 12/6/15.
 */
public class XcriticApplication extends Application {
    private static Context context;
    private static List<ListItemable> favorites = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        XcriticApplication.context = this;
    }

    public static Context getContext() {
        return context;
    }

    public static List<ListItemable> getFavorites() {
        return favorites;
    }
}
