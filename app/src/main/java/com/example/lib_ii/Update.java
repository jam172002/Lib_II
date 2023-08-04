package com.example.lib_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lib_ii.databinding.ActivityUpdateBinding;

public class Update extends AppCompatActivity {

    ActivityUpdateBinding bind;
    String id,name, author, pNumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        gettingData();


        bind.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(Update.this);
                db.update(id, name, author, pNumber);

                startActivity(new Intent(Update.this, Display.class));

            }
        });

    }

    public void gettingData() {
        Intent intent = getIntent();
        if (intent != null &&
                intent.hasExtra("name") &&
                intent.hasExtra("author") &&
                intent.hasExtra("pNumber")) {

            id = intent.getStringExtra("id");
            name = intent.getStringExtra("name");
            author = intent.getStringExtra("author");
            pNumber = intent.getStringExtra("pNumber");


            bind.updName.setText(name);
            bind.updAuthor.setText(author);
            bind.updPNumber.setText(pNumber);
        }
    }
}
