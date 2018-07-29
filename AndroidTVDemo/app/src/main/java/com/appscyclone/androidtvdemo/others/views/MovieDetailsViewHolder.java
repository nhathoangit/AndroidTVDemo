package com.appscyclone.androidtvdemo.others.views;

import android.graphics.drawable.GradientDrawable;
import android.support.v17.leanback.widget.Presenter;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.data.models.MovieDetails;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * Created by NhatHoang on 09/05/2018.
 */
public class MovieDetailsViewHolder extends Presenter.ViewHolder{
    @BindView(R.id.itemDetails_tvTitle)
    TextView movieTitleTV;

    @BindView(R.id.itemDetails_tvMovieYear)
    TextView movieYearTV;

    @BindView(R.id.itemDetails_tvOverview)
    TextView movieOverview;

    @BindView(R.id.itemDetails_tvRunTime)
    TextView mRuntimeTV;

    @BindView(R.id.itemDetails_tvTagLine)
    TextView mTaglineTV;

    @BindView(R.id.itemDetails_tvDirector)
    TextView mDirectorTv;

    @BindView(R.id.itemDetails_tvGenres)
    LinearLayout mGenresLayout;

    private View itemView;

    public MovieDetailsViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        itemView = view;
    }

    public void bind(MovieDetails movie) {
        if (movie != null && movie.getTitle() != null) {
            mRuntimeTV.setText(String.format(Locale.getDefault(), "%d minutes", movie.getRuntime()));
            mTaglineTV.setText(movie.getTagline());
            movieTitleTV.setText(movie.getTitle());
            movieYearTV.setText(String.format(Locale.getDefault(), "(%s)", movie.getReleaseDate().substring(0, 4)));
            movieOverview.setText(movie.getOverview());
            mGenresLayout.removeAllViews();

            if (movie.getDirector() != null) {
                mDirectorTv.setText(String.format(Locale.getDefault(), "Director: %s", movie.getDirector()));
            }

        }

    }
}
