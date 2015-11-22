package fantastic3.xcritic.clients.v2.metacritic;

import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by jpodlech on 11/22/15.
 */
public class MetacriticGames extends MetacriticBase {
    public static void fetchComingSoon(String platform, String listType, String orderBy, Integer page, AsyncHttpResponseHandler cb) {
        String url = getEndpoint("movie-list/coming-soon");
        client.get(url, cb);
    }

    public static void fetchNewReleases(String platform, String listType, String orderBy, Integer page, AsyncHttpResponseHandler cb) {
        String url = getEndpoint("movie-list/new-releases");
        client.get(url, cb);
    }
}
