package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.io.Serializable;
import java.util.Collection;

public class ComingSoonResult {

    private final Collection<Result> results;

    public ComingSoonResult(Collection<Result> results) {
        this.results = results;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public static class Result implements Serializable {
        public final String name;
        public final String score;
        public final String url;
        public final String rlsdate;
        public final String summary;
        public final String rating;
        public final String cast;
        public final String thumbnail;

        public Result(String name, String score, String url, String rlsdate, String summary, String rating, String cast, String thumbnail) {
            this.name = name;
            this.score = score;
            this.url = url;
            this.rlsdate = rlsdate;
            this.summary = summary;
            this.rating = rating;
            this.cast = cast;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public String getScore() {
            return score;
        }

        public String getUrl() {
            return url;
        }

        public String getRlsdate() {
            return rlsdate;
        }

        public String getSummary() {
            return summary;
        }

        public String getRating() {
            return rating;
        }

        public String getCast() {
            return cast;
        }

        public String getThumbnail() {
            return thumbnail;
        }
    }
}
