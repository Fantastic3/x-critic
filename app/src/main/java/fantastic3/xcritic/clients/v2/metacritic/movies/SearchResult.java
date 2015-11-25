package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.util.List;

import lombok.Value;

@Value
public class SearchResult {
    public final Integer      maxPages;
    public final Integer      count;
    public final List<Result> results;

    @Value
    public static class Result {
        public final String name;
        public final String url;
        public final String rlsdate;
        public final String score;
        public final String summary;
        public final String rating;
        public final String cast;
        public final String genre;
        public final String avguserscore;
        public final String runtime;
    }
}
