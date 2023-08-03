package com.example.lib_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lib_ii.databinding.ActivityDisplayBinding;

import java.util.ArrayList;

// The Display class is an Activity that displays a list of books using RecyclerView.
public class Display extends AppCompatActivity {

    // View binding for the activity
    ActivityDisplayBinding bind;

    // ArrayList to hold book data
    ArrayList<Model> arrData = new ArrayList<>();

    // DBHelper instance to interact with the database
    DBHelper db;

    // Adapter for the RecyclerView
    bookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using view binding
        bind = ActivityDisplayBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        // Set an OnClickListener to the "Add" button to navigate to the Add activity
        bind.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Display.this, Add.class));
            }
        });

        // RecyclerView setup
        bind.reV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new bookAdapter(this, arrData);
        bind.reV.setAdapter(adapter);

        // Database work
        // Create a new instance of DBHelper to interact with the database
        db = new DBHelper(Display.this);

        // Retrieve all book data from the database and display it in the Log
        ArrayList<Model> arr = db.getData();
        for (int i = 0; i < arr.size(); i++) {
            Log.d("book info", "id: " + arr.get(i).getM_id() +
                    ", name: " + arr.get(i).getM_name() +
                    ", author: " + arr.get(i).getM_author() +
                    ", pages: " + arr.get(i).getM_page());
        }

        // Retrieve all book data from the database and set it to the RecyclerView
        arrData = db.getData();
        adapter.setData(arrData);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // When the activity resumes, retrieve new data from the database
        // and update the RecyclerView adapter with the new data
        ArrayList<Model> newData = db.getData();
        adapter.setData(newData);
        adapter.notifyDataSetChanged();
    }
}
