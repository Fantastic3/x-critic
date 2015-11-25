package fantastic3.xcritic.clients.v2.metacritic.movies;

import java.io.Serializable;
import java.util.List;

public class SearchResult {
    public final Integer maxPages;
    public final Integer count;
    public final List<Result> results;

    public SearchResult(Integer maxPages, Integer count, List<Result> results) {
        this.maxPages = maxPages;
        this.count = count;
        this.results = results;
    }

    public Integer getMaxPages() {
        return maxPages;
    }

    public Integer getCount() {
        return count;
    }

    public List<Result> getResults() {
        return results;
    }

    public static class Result implements Serializable {
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

        public Result(String name, String url, String rlsdate, String score, String summary, String rating, String cast, String genre, String avguserscore, String runtime) {
            this.name = name;
            this.url = url;
            this.rlsdate = rlsdate;
            this.score = score;
            this.summary = summary;
            this.rating = rating;
            this.cast = cast;
            this.genre = genre;
            this.avguserscore = avguserscore;
            this.runtime = runtime;
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

        public String getSummary() {
            return summary;
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
    }
}
