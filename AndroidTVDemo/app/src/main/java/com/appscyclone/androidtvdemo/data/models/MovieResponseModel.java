package com.appscyclone.androidtvdemo.data.models;

import android.graphics.Movie;

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

public class MovieResponseModel implements Serializable {

    private int page;
    private List<MovieModel> results;

    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;

    public int getPage() {
        return page;
    }

    public MovieResponseModel setPage(int page) {
        this.page = page;
        return this;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

}
