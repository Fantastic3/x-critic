package fantastic3.xcritic.clients.v2.metacritic;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by jpodlech on 11/22/15.
 */
public class MetacriticMusic extends MetacriticBase {
    private static final String BASE_PATH = "album-list";

    public static void fetchBy(String listType, String orderBy, Integer page, AsyncHttpResponseHandler cb) {
        if (listType == null) listType = "new-releases";
        String endpoint = getEndpoint(StringUtils.join(Arrays.asList(BASE_PATH, listType), "/"));
        client.get(endpoint, cb);
    }
}
