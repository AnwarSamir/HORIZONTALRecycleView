package com.asi.hor;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder  {
    // View holder for gridview recycler view as we used in listview
    public TextView title;
    public ImageView imageview;
    //add anim to card view
    public CardView cardView;




    public RecyclerViewHolder(View view) {
        super(view);
        // Find all views ids

        this.title = (TextView) view
                .findViewById(R.id.title);
        this.imageview = (ImageView) view
                .findViewById(R.id.image);
        this.cardView= (CardView) view.findViewById(R.id.card_view);


    }

    public void clearAnimation()
    {
        cardView.clearAnimation();
    }

}