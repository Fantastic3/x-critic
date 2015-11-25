package fantastic3.xcritic.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jpodlech on 11/24/15.
 */
public class Game {
    private String name;
    private String url;
    private String releaseDate;
    private String rating;
    private String score;
    private String thumbnail;

    public Game(String name, String url, String releaseDate, String rating, String score, String thumbnail) {
        this.name = name;
        this.url = url;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.score = score;
        this.thumbnail = thumbnail;
    }

    public static ArrayList<Game> fromJSONResults(JSONObject json) {
        ArrayList<Game> list = new ArrayList<Game>();
        JSONArray results = null;
        try {
            results = json.getJSONArray("results");
            for (Integer i = 0; i < results.length(); i++) {
                list.add(fromJSONObject(results.getJSONObject(i)));
            }
        } catch (JSONException e) {
            Log.e("G.fromJSONResults", e.getStackTrace().toString());
        }
        return list;
    }

    public static Game fromJSONObject(JSONObject json) {
        Game game = null;
        try {
            String name = json.getString("name");
            String url = json.getString("url");
            String releaseDate = json.getString("rlsdate");
            String rating = json.getString("rating");
            String score = json.getString("score");
            String thumbnail = json.getString("thumbnail");
            game = new Game(name, url, releaseDate, rating, score, thumbnail);
        } catch (JSONException e) {
            Log.e("M.fromJSONObject", e.getStackTrace().toString());
        }
        return game;
    }
}
