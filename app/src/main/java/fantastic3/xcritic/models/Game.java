package fantastic3.xcritic.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fantastic3.xcritic.interfaces.ListItemable;

/**
 * Created by jpodlech on 11/24/15.
 */
public class Game implements Parcelable, ListItemable {
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

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getScore() {
        return score;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public static ArrayList<Game> fromJSONResults(JSONObject json) {
        ArrayList<Game> list = new ArrayList<Game>();
        try {
            JSONArray results = json.getJSONArray("results");
            for (Integer i = 0; i < results.length(); i++) {
                Game game = fromJSONObject(results.getJSONObject(i));
                if (game != null) list.add(game);
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
            Log.e("G.fromJSONObject", e.getStackTrace().toString());
        }
        return game;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.releaseDate);
        dest.writeString(this.rating);
        dest.writeString(this.score);
        dest.writeString(this.thumbnail);
    }

    protected Game(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
        this.releaseDate = in.readString();
        this.rating = in.readString();
        this.score = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
