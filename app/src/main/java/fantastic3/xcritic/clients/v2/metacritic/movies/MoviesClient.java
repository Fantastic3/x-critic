package fantastic3.xcritic.clients.v2.metacritic.movies;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MoviesClient {
    @GET("/find/movie")
    Call<FindResult> find(@Query("title") String title);

    @GET("/movie-list/new-releases")
    Call<NewReleasesResult> newReleases(@Query("orderBy") OrderBy orderBy);

    @GET("/movie-list/coming-soon")
    Call<ComingSoonResult> comingSoon();

    @GET("/search/movie")
    Call<SearchResult> search(@Query("max_pages") String maxPages,
                              @Query("title") String title,
                              @Query("year_from") String yearFrom,
                              @Query("year_to") String yearTo);
}
