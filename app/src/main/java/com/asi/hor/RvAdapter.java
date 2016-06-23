package com.asi.hor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class RvAdapter extends
        RecyclerView.Adapter<RecyclerViewHolder> {// Recyclerview will extend to
    // recyclerview adapter
    private ArrayList<ItemModel> arrayList;
    private Context context;
    private int lastPosition=-1;

    public RvAdapter(Context context,
                     ArrayList<ItemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }



    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final ItemModel model = arrayList.get(position);

        RecyclerViewHolder mainHolder = (RecyclerViewHolder) holder;// holder

        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
                model.getImage());// This will convert drawbale image into
        // bitmap

        // setting title
        mainHolder.title.setText(model.getTitle());

        mainHolder.imageview.setImageBitmap(image);
//add anim to card view
        setAnimation(holder.cardView, position);



    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item, viewGroup, false);
        RecyclerViewHolder listHolder = new RecyclerViewHolder(mainGroup);
        return listHolder;

    }


    //
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated

        if (position > lastPosition)
        {

            Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.slide_down : R.anim.slide_up);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }



    }
    //to solve the problem of fast scroll
    @Override
    public void onViewDetachedFromWindow(RecyclerViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        ((RecyclerViewHolder)holder).clearAnimation();
    }

}