package fantastic3.xcritic.clients.v2.metacritic;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class HeadersInterceptor implements Interceptor {
    private static final String API_KEY       = "pBAqDZQ369msh8AOeHJspADQSGOKp1Xh4j6jsnynrcvAJmEKoS";
    private static final long   MAX_AGE       = 3600;
    private static final long   MAX_STALE     = 3600;
    private static final String CACHE_CONTROL = String.format("max-age=%d, only-if-cached, max-stale=%d",
                                                              MAX_AGE,
                                                              MAX_STALE);

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request originalRequest = chain.request();
        final Request requestWithHeaders = originalRequest.newBuilder()
                                                          .header("Accept", "application/json")
                                                          .header("X-Mashape-Key", API_KEY)
                                                          .method(originalRequest.method(), originalRequest.body())
                                                          .build();

        final Response originalResponse = chain.proceed(requestWithHeaders);
        return originalResponse.newBuilder().header("Cache-Control", CACHE_CONTROL).build();
    }
}
