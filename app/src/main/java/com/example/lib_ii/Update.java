package com.example.lib_ii;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(name);
        }


        bind.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(Update.this);

                // Log the values before updating
                Log.d("UpdateActivity", "id: " + id + ", name: " + name + ", author: " + author + ", pNumber: " + pNumber);

                String name = bind.updName.getText().toString();
               String author = bind.updAuthor.getText().toString();
               String pNumber = bind.updPNumber.getText().toString();
                db.update(id, name, author, pNumber);

                // Log a message after the update method is called
                Log.d("UpdateActivity", "Update method called.");

                startActivity(new Intent(Update.this, Display.class));
            }
        });

       /* bind.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(Update.this);
                ad.setTitle("Delete " + name + " ?");
                ad.setMessage("Are you to delete this data");
                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBHelper db = new DBHelper(Update.this);
                        db.delRow(id);
                        finish();
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
            ad.create().show();

            }


        });*/

    }


    public void gettingData() {
        Intent intent = getIntent();

        //check so that data is transferred successfully so that intent is mot empty
        if (intent != null &&
                intent.hasExtra("name") &&
                intent.hasExtra("author") &&
                intent.hasExtra("pNumber")) {

            //get and store the data from intent to local variables
            id = intent.getStringExtra("id");
            name = intent.getStringExtra("name");
            author = intent.getStringExtra("author");
            pNumber = intent.getStringExtra("pNumber");


            bind.updName.setText(name);
            bind.updAuthor.setText(author);
            bind.updPNumber.setText(pNumber);
        }
    }

    public void DelAction(){

    }
}
