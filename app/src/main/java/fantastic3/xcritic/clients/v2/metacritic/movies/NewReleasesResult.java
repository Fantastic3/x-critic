package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.io.Serializable;
import java.util.List;

import fantastic3.xcritic.models.Movie;

public class NewReleasesResult {
    private final List<Movie> results;

    public NewReleasesResult(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public static class Result implements Serializable {
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

        public Result(String name, String url, String rlsdate, String score, String rating, String cast, String genre, String avguserscore, String runtime, String thumbnail) {
            this.name = name;
            this.url = url;
            this.rlsdate = rlsdate;
            this.score = score;
            this.rating = rating;
            this.cast = cast;
            this.genre = genre;
            this.avguserscore = avguserscore;
            this.runtime = runtime;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public String getRlsdate() {
            return rlsdate;
        }

        public String getScore() {
            return score;
        }

        public String getRating() {
            return rating;
        }

        public String getCast() {
            return cast;
        }

        public String getGenre() {
            return genre;
        }

        public String getAvguserscore() {
            return avguserscore;
        }

        public String getRuntime() {
            return runtime;
        }

        public String getThumbnail() {
            return thumbnail;
        }
    }
}
