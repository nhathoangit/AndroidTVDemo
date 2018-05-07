package com.appscyclone.androidtvdemo.ui.presenters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.models.MovieModel;
import com.appscyclone.androidtvdemo.others.AppUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.net.URI;

/*
 * Created by NhatHoang on 07/05/2018.
 */
public class CardPresenter extends Presenter {
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 176;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ImageCardView cardView = new ImageCardView(parent.getContext());
        cardView.setCardType(BaseCardView.CARD_TYPE_INFO_UNDER);
        cardView.setInfoVisibility(BaseCardView.CARD_REGION_VISIBLE_ALWAYS);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setBackgroundColor(parent.getContext().getResources().getColor(R.color.default_background));
        cardView.setInfoAreaBackgroundColor(parent.getContext().getResources().getColor(R.color.fastlane_background));
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        MovieModel movie = (MovieModel) item;
        ((CardViewHolder) viewHolder).setMovie(movie);
        if (movie.getCardImageUrl() != null) {
            ((CardViewHolder) viewHolder).mCardView.setTitleText(movie.getTitle());
            ((CardViewHolder) viewHolder).mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
            ((CardViewHolder) viewHolder).updateCardViewImage(movie.getCardImageURI());
            //((ViewHolder) viewHolder).mCardView.setMainImage(((ViewHolder) viewHolder).getDefaultCardImage());
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }


    public static class PicassoImageCardViewTarget implements Target {
        private ImageCardView mImageCardView;

        public PicassoImageCardViewTarget(ImageCardView imageCardView) {
            mImageCardView = imageCardView;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            Drawable bitmapDrawable = new BitmapDrawable(mImageCardView.getContext().getResources(), bitmap);
            mImageCardView.setMainImage(bitmapDrawable);
        }

        @Override
        public void onBitmapFailed(Drawable drawable) {
            mImageCardView.setMainImage(drawable);
        }

        @Override
        public void onPrepareLoad(Drawable drawable) {
            // Do nothing, default_background manager has its own transitions
        }
    }

    static class CardViewHolder extends Presenter.ViewHolder {
        private MovieModel mMovie;
        private ImageCardView mCardView;
        private Drawable mDefaultCardImage;
        private PicassoImageCardViewTarget mImageCardViewTarget;

        public CardViewHolder(View view) {
            super(view);
            //mCardView = view.findViewById(R.id.itemCard_imvCard);
            mCardView = (ImageCardView) view;
            mImageCardViewTarget = new PicassoImageCardViewTarget(mCardView);
            mDefaultCardImage =  view.getContext().getResources().getDrawable(R.drawable.movie);
        }

        protected void updateCardViewImage(URI uri) {
            Picasso.with(view.getContext())
                    .load(uri.toString())
                    .resize(AppUtils.convertDpToPixel(mCardView.getContext(), CARD_WIDTH),
                            AppUtils.convertDpToPixel(mCardView.getContext(), CARD_HEIGHT))
                    .placeholder(mDefaultCardImage)
                    .error(mDefaultCardImage)
                    .into(mImageCardViewTarget);
        }

        public MovieModel getMovie() {
            return mMovie;
        }

        public void setMovie(MovieModel m) {
            mMovie = m;
        }

        public ImageCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }

    }

}
