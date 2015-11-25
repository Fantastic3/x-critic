package fantastic3.xcritic.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jpodlech on 11/24/15.
 */
public class Music {
    private String author;
    private String name;
    private String url;
    private String releaseDate;
    private String score;
    private String userScore;
    private String genre;
    private String thumbnail;

    public Music(String author, String name, String url, String releaseDate, String score, String userScore, String genre, String thumbnail) {
        this.author = author;
        this.name = name;
        this.url = url;
        this.releaseDate = releaseDate;
        this.score = score;
        this.userScore = userScore;
        this.genre = genre;
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
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

    public String getUserScore() {
        return userScore;
    }

    public String getGenre() {
        return genre;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public static ArrayList<Music> fromJSONResults(JSONObject json) {
        ArrayList<Music> list = new ArrayList<Music>();
        try {
            JSONArray results = json.getJSONArray("results");
            for (Integer i = 0; i < results.length(); i++) {
                list.add(fromJSONObject(results.getJSONObject(i)));
            }
        } catch (JSONException e) {
            Log.e("Mu.fromJSONResults", e.getStackTrace().toString());
        }
        return list;
    }

    public static Music fromJSONObject(JSONObject json) {
        Music music = null;
        try {
            String author = json.getString("author");
            String name = json.getString("name");
            String url = json.getString("url");
            String releaseDate = json.getString("rlsdate");
            String score = json.getString("score");
            String userscore = json.getString("avguserscore");
            String genre = json.getString("genre");
            String thumbnail = json.getString("thumbnail");
            music = new Music(author, name, url, releaseDate, score, userscore, genre, thumbnail);
        } catch (JSONException e) {
            Log.e("M.fromJSONObject", e.getStackTrace().toString());
        }
        return music;
    }
}
