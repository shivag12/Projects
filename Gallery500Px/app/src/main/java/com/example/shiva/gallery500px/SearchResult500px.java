package com.example.shiva.gallery500px;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchResult500px extends AppCompatActivity {

    ListView listViewSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result500px);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        listViewSearchResults = (ListView) findViewById(R.id.lvSearchResults);

        ArrayList<ImagePx> imagePxArrayList = new ArrayList<ImagePx>();


        CustomListView500Px customListView500Px = new CustomListView500Px(this,R.layout.searchresult_eachrow,imagePxArrayList);

        listViewSearchResults.setAdapter(customListView500Px);

    }

}
