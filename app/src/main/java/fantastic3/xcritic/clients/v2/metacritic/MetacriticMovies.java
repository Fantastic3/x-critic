package fantastic3.xcritic.clients.v2.metacritic;

import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by jpodlech on 11/22/15.
 */
public class MetacriticMovies extends MetacriticBase {
    public static void fetchComingSoon(AsyncHttpResponseHandler cb) {
        String url = getEndpoint("movie-list/coming-soon");
        client.get(url, cb);
    }

    public static void fetchNewReleases(String orderBy, AsyncHttpResponseHandler cb) {
        String url = getEndpoint("movie-list/coming-soon");
        client.get(url, cb);
    }
}
