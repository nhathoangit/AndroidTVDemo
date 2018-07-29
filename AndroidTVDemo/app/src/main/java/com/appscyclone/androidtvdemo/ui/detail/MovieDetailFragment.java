package com.appscyclone.androidtvdemo.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewLogoPresenter;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

/*
 * Created by NhatHoang on 09/05/2018.
 */
public class MovieDetailFragment extends DetailsFragment {

    public static String TRANSITION_NAME = "poster_transition";
    private CustomMovieDetailsPresenter mFullWidthMovieDetailsPresenter;
    private ArrayObjectAdapter mAdapter;
    String mYoutubeID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpAdapter();
    }

    private void setUpAdapter() {
        // Create the FullWidthPresenter
        mFullWidthMovieDetailsPresenter = new CustomMovieDetailsPresenter(new MovieDetailsDescriptionPresenter(),
                new DetailsOverviewLogoPresenter());

        // Handle the transition, the Helper is mainly used because the ActivityTransition is being passed from
        // The Activity into the Fragment
        FullWidthDetailsOverviewSharedElementHelper helper = new FullWidthDetailsOverviewSharedElementHelper();
        helper.setSharedElementEnterTransition(getActivity(), TRANSITION_NAME); // the transition name is important
        mFullWidthMovieDetailsPresenter.setListener(helper); // Attach the listener
        // Define if this element is participating in the transition or not
        mFullWidthMovieDetailsPresenter.setParticipatingEntranceTransition(false);

        mFullWidthMovieDetailsPresenter.setOnActionClickedListener(action -> {
            int actionId = (int) action.getId();
            switch (actionId) {
                case 0:
                    if (mYoutubeID != null) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + mYoutubeID)));
                    }
                    break;
            }
        });


        // Class presenter selector allows the Adapter to render Rows and the details
        // It can be used in any of the Adapters by the Leanback library
        ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
        classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, mFullWidthMovieDetailsPresenter);
        classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        mAdapter = new ArrayObjectAdapter(classPresenterSelector);
        setAdapter(mAdapter);
    }
}
