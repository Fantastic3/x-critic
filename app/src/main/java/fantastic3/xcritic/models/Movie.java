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
 * Created by jpodlech on 11/23/15.
 */
public class Movie implements Parcelable, ListItemable {
    private String name;
    private String url;
    private String releaseDate;
    private String score;
    private String rating;
    private String cast;
    private String genre;
    private String userScore;
    private String director = "";
    private String runtime;
    private String thumbnail;

    private String summary;

    public Movie(String name, String url, String releaseDate, String score, String rating, String cast, String genre, String userScore, String runtime, String thumbnail, String summary) {
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
        this.summary = summary;
    }

    public String getSummary() { return "After the crew of the Enterprise find an unstoppable force of terror from within their own organization, Captain Kirk leads a manhunt to a war-zone world to capture a one man weapon of mass destruction."; }

    public String getDirector() { return "J.J. Abrams"; }

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
            String summary = json.getString("summary");
            String url = json.getString("url");
            String releaseDate = json.getString("rlsdate");
            String score = json.getString("score");
            String rating = json.getString("rating");
            //String director = json.getString("director");
            String cast = json.getString("cast");
            String genre = json.getString("genre");
            String userscore = json.getString("avguserscore");
            String runtime = json.getString("runtime");
            String thumbnail;
            if(!json.isNull("thumbnail")){
                thumbnail = json.getString("thumbnail");
            }
            else{
                thumbnail = "http://www.solarmonitor.org/common_files/NoData/thumb/swap_00174_thumb.png";
            }

            movie = new Movie(name, url, releaseDate, score, rating, cast, genre, userscore, runtime, thumbnail, summary);
        } catch (JSONException e) {
            Log.e("M.fromJSONObject", e.getStackTrace().toString());
        }
        return movie;
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
        dest.writeString(this.score);
        dest.writeString(this.rating);
        dest.writeString(this.cast);
        dest.writeString(this.genre);
        dest.writeString(this.userScore);
        dest.writeString(this.runtime);
        dest.writeString(this.thumbnail);
    }

    protected Movie(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
        this.releaseDate = in.readString();
        this.score = in.readString();
        this.rating = in.readString();
        this.cast = in.readString();
        this.genre = in.readString();
        this.userScore = in.readString();
        this.runtime = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
