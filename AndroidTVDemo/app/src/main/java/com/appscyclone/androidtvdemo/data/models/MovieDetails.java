package com.appscyclone.androidtvdemo.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by <a href="mailto:marcus@gabilheri.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 10/9/16.
 */

public class MovieDetails extends BaseModel {

    private boolean adult;
    private String overview;
    private boolean video;
    private List<Genre> genres;
    private String title;
    private float popularity;
    private int budget;
    private int runtime;
    private int revenue;
    private String tagline;
    private String status;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("imdb_id")
    private String imdbId;

    private String director;

    public MovieDetails() {
    }

    public boolean isAdult() {
        return adult;
    }

    public MovieDetails setAdult(boolean adult) {
        this.adult = adult;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public MovieDetails setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public boolean isVideo() {
        return video;
    }

    public MovieDetails setVideo(boolean video) {
        this.video = video;
        return this;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public MovieDetails setGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public float getPopularity() {
        return popularity;
    }

    public MovieDetails setPopularity(float popularity) {
        this.popularity = popularity;
        return this;
    }

    public int getBudget() {
        return budget;
    }

    public MovieDetails setBudget(int budget) {
        this.budget = budget;
        return this;
    }

    public int getRuntime() {
        return runtime;
    }

    public MovieDetails setRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }

    public int getRevenue() {
        return revenue;
    }

    public MovieDetails setRevenue(int revenue) {
        this.revenue = revenue;
        return this;
    }

    public String getTagline() {
        return tagline;
    }

    public MovieDetails setTagline(String tagline) {
        this.tagline = tagline;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public MovieDetails setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public MovieDetails setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public MovieDetails setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public MovieDetails setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public MovieDetails setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public MovieDetails setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public MovieDetails setVoteCount(int voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public MovieDetails setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public String getImdbId() {
        return imdbId;
    }

    public MovieDetails setImdbId(String imdbId) {
        this.imdbId = imdbId;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public MovieDetails setDirector(String director) {
        this.director = director;
        return this;
    }

}
