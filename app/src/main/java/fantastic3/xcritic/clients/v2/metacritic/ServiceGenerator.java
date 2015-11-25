package fantastic3.xcritic.clients.v2.metacritic;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ServiceGenerator {
    private static final long   CACHE_SIZE   = 10 * 1024 * 1024;
    private static final String API_BASE_URL = "https://metacritic-2.p.mashape.com";

    private final OkHttpClient httpClient;
    private final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private ServiceGenerator(final File cacheDirectory) {
        httpClient = build(new OkHttpClient(), cacheDirectory);
        httpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        httpClient.setReadTimeout(60, TimeUnit.SECONDS);
    }

    public static ServiceGenerator build(final File cacheDirectory) {
        return new ServiceGenerator(cacheDirectory);
    }

    public <S> S createService(final Class<S> serviceClass) {
        return builder.client(httpClient).build().create(serviceClass);
    }

    private OkHttpClient build(final OkHttpClient httpClient, final File cacheDiractory) {
        httpClient.networkInterceptors().add(new HeadersInterceptor());
        httpClient.networkInterceptors().add(new HttpLoggingInterceptor());
        httpClient.setCache(new Cache(cacheDiractory, CACHE_SIZE));
        return httpClient;
    }
}
