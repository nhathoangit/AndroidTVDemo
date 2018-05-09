package com.appscyclone.androidtvdemo.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.util.SparseArray;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.data.api.TheMovieDbAPI;
import com.appscyclone.androidtvdemo.data.models.MovieModel;
import com.appscyclone.androidtvdemo.data.models.MovieResponseModel;
import com.appscyclone.androidtvdemo.data.models.MovieRow;
import com.appscyclone.androidtvdemo.ui.bases.BaseApplication;
import com.appscyclone.androidtvdemo.ui.presenters.CardPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*
 * Created by NhatHoang on 07/05/2018.
 */
public class MainFragment extends BrowseFragment {
    @Inject
    TheMovieDbAPI mDbAPI;
    SparseArray<MovieRow> mRows;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseApplication.instance().appComponent().inject(this);
        setupUIElements();
        createDataRows();
        createRows();
        fetchNowPlayingMovies();
    }

    private void setupUIElements() {
        setTitle("Hello Android TV!"); // Badge, when set, takes precedent
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private void createRows() {
        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        for (int i = 0; i < mRows.size(); i++) {
            MovieRow row = mRows.get(i);
            HeaderItem headerItem = new HeaderItem(row.getId(), row.getTitle());
            ListRow listRow = new ListRow(headerItem, row.getAdapter());
            rowsAdapter.add(listRow);
        }
        setAdapter(rowsAdapter);
    }

    @SuppressLint("CheckResult")
    private void fetchNowPlayingMovies() {
        mDbAPI.getNowPlayingMovies("7d667828c3db37bf5f3131272d985c5b", mRows.get(0).getPage())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    bindMovieResponse(response, 0);
                    startEntranceTransition();
                }, e -> {
                    //Timber.e(e, "Error fetching now playing movies: %s", e.getMessage());
                });
    }

    private void bindMovieResponse(MovieResponseModel response, int id) {
        MovieRow row = mRows.get(id);
        row.setPage(row.getPage() + 1);
        for (MovieModel m : response.getResults()) {
            if (m.getPosterPath() != null) { // Avoid showing movie without posters
                row.getAdapter().add(m);
            }
        }
    }

    private void createDataRows() {
        mRows = new SparseArray<>();
        CardPresenter moviePresenter = new CardPresenter();
        mRows.put(0, new MovieRow()
                .setId(0)
                .setAdapter(new ArrayObjectAdapter(moviePresenter))
                .setTitle("Now Playing")
                .setPage(1)
        );
    }
}
