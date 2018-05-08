package com.appscyclone.androidtvdemo.others.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.models.MovieModel;
import com.bumptech.glide.Glide;

import java.util.Locale;

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
                .load(data.getCardImageUrl())
                .into(imvPoster);
        tvVote.setText(data.getTitle());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.item_card;
    }
}
