package fantastic3.xcritic.clients.v2.metacritic;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;

import java.net.MalformedURLException;
import java.net.URL;

import fantastic3.xcritic.configs.v2.MetacriticConfig;

/**
 * Created by jpodlech on 11/22/15.
 */
public abstract class MetacriticBase extends AsyncHttpClient {
    protected static final AsyncHttpClient client = new AsyncHttpClient() {
        {
            client.addHeader("X-Mashape-Key", MetacriticConfig.API_KEY);
            client.addHeader("Accept", "application/json");
        }
    };

    protected static String getEndpoint(String path) {
        String endpoint = null;
        try {
            endpoint = new URL(MetacriticConfig.API_BASE_URL + path).toString();
        } catch (MalformedURLException e) {
            Log.e("MB.getEndpoint", e.getStackTrace().toString());
        }
        return endpoint;
    }

}
