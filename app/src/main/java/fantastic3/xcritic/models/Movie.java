package fantastic3.xcritic.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jpodlech on 11/23/15.
 */
public class Movie {
    private String name;
    private String url;
    private String releaseDate;
    private String score;
    private String rating;
    private String cast;
    private String genre;
    private String userScore;
    private String runtime;
    private String thumbnail;

    public Movie(String name, String url, String releaseDate, String score, String rating, String cast, String genre, String userScore, String runtime, String thumbnail) {
        this.name = name;
        this.url = url;
        this.releaseDate = releaseDate;
        this.score = score;
        this.rating = rating;
        this.cast = cast;
        this.genre = genre;
        this.userScore = userScore;
        this.runtime = runtime;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getReleaseDate() {
        return releaseDate;
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

    public String getUserScore() {
        return userScore;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public static ArrayList<Movie> fromJSONResults(JSONObject json) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        try {
            JSONArray results = json.getJSONArray("results");
            for (Integer i = 0; i < results.length(); i++) {
                list.add(fromJSONObject(results.getJSONObject(i)));
            }
        } catch (JSONException e) {
            Log.e("Mo.fromJSONResults", e.getStackTrace().toString());
        }
        return list;
    }

    public static Movie fromJSONObject(JSONObject json) {
        Movie movie = null;
        try {
            String name = json.getString("name");
            String url = json.getString("url");
            String releaseDate = json.getString("rlsdate");
            String score = json.getString("score");
            String rating = json.getString("rating");
            String cast = json.getString("cast");
            String genre = json.getString("genre");
            String userscore = json.getString("avguserscore");
            String runtime = json.getString("runtime");
            String thumbnail = json.getString("thumbnail");
            movie = new Movie(name, url, releaseDate, score, rating, cast, genre, userscore, runtime, thumbnail);
        } catch (JSONException e) {
            Log.e("M.fromJSONObject", e.getStackTrace().toString());
        }
        return movie;
    }
}
