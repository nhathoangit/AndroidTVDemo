package com.appscyclone.androidtvdemo.ui.detail;

import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.data.models.MovieDetails;
import com.appscyclone.androidtvdemo.others.views.MovieDetailsViewHolder;

/*
 * Created by NhatHoang on 09/05/2018.
 */
public class MovieDetailsDescriptionPresenter extends Presenter{
    @Override
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, parent, false);
        return new MovieDetailsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        MovieDetails movie = (MovieDetails) item;
        MovieDetailsViewHolder holder = (MovieDetailsViewHolder) viewHolder;
        holder.bind(movie);
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }
}
