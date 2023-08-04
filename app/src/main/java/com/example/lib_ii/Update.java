package com.example.lib_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lib_ii.databinding.ActivityUpdateBinding;

public class Update extends AppCompatActivity {

    ActivityUpdateBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        gettingData();

    }

    public void gettingData() {
        Intent intent = getIntent();
        if (intent != null &&
                intent.hasExtra("name") &&
                intent.hasExtra("author") &&
                intent.hasExtra("pNumber")) {

            String name = intent.getStringExtra("name");
            String author = intent.getStringExtra("author");
            String pNumber = intent.getStringExtra("pNumber");

            bind.updName.setText(name);
            bind.updAuthor.setText(author);
            bind.updPNumber.setText(pNumber);
        }
    }
}
