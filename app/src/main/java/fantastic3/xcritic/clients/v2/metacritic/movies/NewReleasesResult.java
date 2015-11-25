package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.util.Collection;

import lombok.Value;

@Value
public class NewReleasesResult {
    private final Collection<Result> results;

    @Value
    private static class Result {
        public final String name;
        public final String url;
        public final String rlsdate;
        public final String score;
        public final String rating;
        public final String cast;
        public final String genre;
        public final String avguserscore;
        public final String runtime;
        public final String thumbnail;
    }
}
