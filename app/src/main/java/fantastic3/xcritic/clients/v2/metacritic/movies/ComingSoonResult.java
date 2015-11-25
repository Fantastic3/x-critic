package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.util.Collection;

import lombok.Value;

@Value
public class ComingSoonResult {

    private final Collection<Result> results;

    @Value
    public static class Result {
        public final String name;
        public final String score;
        public final String url;
        public final String rlsdate;
        public final String summary;
        public final String rating;
        public final String cast;
        public final String thumbnail;
    }
}
