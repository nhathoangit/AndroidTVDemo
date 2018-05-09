package com.appscyclone.androidtvdemo.data.models;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by <a href="mailto:marcus@gabilheri.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/8/16.
 */

public class MovieModel extends BaseModel {

    private String id;
    @SerializedName("poster_path")
    private String posterPath;
    private boolean adult;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private List<String> genreIds;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private float popularity;
    @SerializedName("vote_count")
    private int voteCount;
    private boolean video;
    @SerializedName("vote_average")
    private float voteAverage;

    public MovieModel() {
    }

    protected MovieModel(Parcel in) {
        this.id = in.readString();
        this.posterPath = in.readString();
        this.adult = in.readByte() != 0;
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.genreIds = in.createStringArrayList();
        this.originalTitle = in.readString();
        this.originalLanguage = in.readString();
        this.title = in.readString();
        this.backdropPath = in.readString();
        this.popularity = in.readFloat();
        this.voteCount = in.readInt();
        this.video = in.readByte() != 0;
        this.voteAverage = in.readFloat();
    }

    public String getId() {
        return id;
    }

    public MovieModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public MovieModel setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public boolean isAdult() {
        return adult;
    }

    public MovieModel setAdult(boolean adult) {
        this.adult = adult;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public MovieModel setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public MovieModel setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public List<String> getGenreIds() {
        return genreIds;
    }

    public MovieModel setGenreIds(List<String> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public MovieModel setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public MovieModel setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public MovieModel setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public float getPopularity() {
        return popularity;
    }

    public MovieModel setPopularity(float popularity) {
        this.popularity = popularity;
        return this;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public MovieModel setVoteCount(int voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public boolean isVideo() {
        return video;
    }

    public MovieModel setVideo(boolean video) {
        this.video = video;
        return this;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public MovieModel setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

}
