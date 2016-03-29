package com.asi.hor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;

    //String and Integer array for Recycler View Items
    public static final String[] TITLES = {"item one", "item two", "item three", "item four", "item five"};
    public static final Integer[] IMAGES = {R.drawable.bag, R.drawable.city, R.drawable.man, R.drawable.fruit, R.drawable.people};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        populatRecyclerView();
    }

    // populate the list view by adding data to arraylist
    private void populatRecyclerView() {
        ArrayList<ItemModel> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new ItemModel(TITLES[i], IMAGES[i]));
        }
        RvAdapter adapter = new RvAdapter(MainActivity.this, arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter

    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Set Back Icon on Activity
        recyclerView = (RecyclerView)
                findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        //Set RecyclerView type according to intent value
        recyclerView
                .setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

    }
}
