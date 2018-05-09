package com.appscyclone.androidtvdemo.others.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.dagger.modules.HttpClientModule;
import com.appscyclone.androidtvdemo.data.models.MovieModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * Created by NhatHoang on 08/05/2018.
 */
public class MovieCardView extends BindableCardView<MovieModel> {

    @BindView(R.id.itemCard_imvPoster)
    ImageView imvPoster;

    @BindView(R.id.itemCard_tvVote)
    TextView tvVote;

    public MovieCardView(Context context) {
        super(context);
        ButterKnife.bind(this);
    }

    @Override
    public void bind(MovieModel data) {
        Glide.with(getContext())
                .load("http://image.tmdb.org/t/p/w600/" + data.getPosterPath())
                .into(imvPoster);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.item_card;
    }
}
