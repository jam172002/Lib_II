package com.example.lib_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lib_ii.databinding.ActivityDisplayBinding;

import java.util.ArrayList;


public class Display extends AppCompatActivity {

    ActivityDisplayBinding bind;
    ArrayList<Model> arrData = new ArrayList<>();
    DBHelper db;
    bookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityDisplayBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        //add button taking to add activity
        bind.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Display.this, Add.class));
            }
        });

       /* arrData.add(new Model(122, "Biology", "PCTB", "300"));
        arrData.add(new Model(26, "Chemistry", "PCTB", "250"));
        arrData.add(new Model(5, "Physics", "PCTB", "350"));*/

        bind.reV.setLayoutManager(new LinearLayoutManager(this));

        adapter = new bookAdapter(this, arrData);

        bind.reV.setAdapter(adapter);



        //Database work now
        db = new DBHelper(Display.this);
        ArrayList<Model> arr = db.getData();

        for (int i = 0; i < arr.size(); i++) {
            Log.d("book info", "id: " + arr.get(i).getM_id() +
                    ", name: " + arr.get(i).getM_name() +
                    ", author: " + arr.get(i).getM_author() +
                    ", pages: " + arr.get(i).getM_page());
        }


        arrData = db.getData();
        adapter.setData(arrData);


    }
    @Override
    protected void onResume() {
        super.onResume();

        // Retrieve new data from the database when the activity resumes
        ArrayList<Model> newData = db.getData();
        adapter.setData(newData);
        adapter.notifyDataSetChanged();
    }

}