package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.util.List;

import lombok.Value;

@Value
public class FindResult {
    private final Result result;


    @Value
    public static class Result {
        private final String       name;
        private final String       score;
        private final List<String> genre;
        private final String       thumbnail;
        private final double       userscore;
        private final String       summary;
        private final String       platform;
        private final String       publisher;
        private final String       developer;
        private final String       rating;
        private final String       rlsdate;
        private final String       url;
    }
}
