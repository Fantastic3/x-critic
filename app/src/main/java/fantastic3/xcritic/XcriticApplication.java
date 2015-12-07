package fantastic3.xcritic;

import android.app.Application;
import android.content.Context;

/**
 * Created by jpodlech on 12/6/15.
 */
public class XcriticApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        XcriticApplication.context = this;
    }

    public static Context getContext() {
        return context;
    }
}
