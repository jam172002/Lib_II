package com.example.lib_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lib_ii.databinding.ActivityAddBinding;

public class Add extends AppCompatActivity {

    ActivityAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String author = binding.author.getText().toString();
                String pNumber = binding.pNumber.getText().toString();

                DBHelper db = new DBHelper(Add.this);

                //calling and passing the data items to the add method created in dbhelper
                db.addData(name, author, pNumber);

                //after addition of data it will direct us to the main or displaying activity
                startActivity(new Intent(Add.this, Display.class));
            }
        });
    }
}