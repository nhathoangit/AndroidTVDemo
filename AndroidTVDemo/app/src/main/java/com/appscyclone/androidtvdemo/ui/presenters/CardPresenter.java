package com.appscyclone.androidtvdemo.ui.presenters;

import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

import com.appscyclone.androidtvdemo.models.MovieModel;
import com.appscyclone.androidtvdemo.others.views.MovieCardView;

/*
 * Created by NhatHoang on 07/05/2018.
 */
public class CardPresenter extends Presenter {
    public CardPresenter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(new MovieCardView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ((MovieCardView) viewHolder.view).bind((MovieModel) item);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

}
