package com.example.lib_ii;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "Database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "BOOK_DATA";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "BOOK";
    private static final String COL_AUTHOR = "AUTHOR";
    private static final String COL_PAGES = "NAME_OF_PAGES";


    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY autoincrement, " +
                COL_NAME + " TEXT, " +
                COL_AUTHOR + " TEXT, " +
                COL_PAGES + " TEXT);";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public  void addData(String name,String author,String pNumber){
        ContentValues val = new ContentValues();
        //id colomn will not be put because it is declared as autoincrement
        val.put(COL_NAME, name);
        val.put(COL_AUTHOR, author);
        val.put(COL_PAGES, pNumber);

        SQLiteDatabase db = this.getWritableDatabase();

        //to check the data is added otherwise any error can happen
        long result = db.insert(TABLE_NAME, null, val);
        if (result == -1){
            Toast.makeText(context, "Failed to add Data", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Data Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    //take data from database by cursor and store it in the arraylist and return it
    public ArrayList<Model> getData(){
        ArrayList<Model> arrData = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ TABLE_NAME, null);

        if(cursor.getCount() == 0){
            Toast.makeText(context, "No Data", Toast.LENGTH_SHORT).show();
        }
        else {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_ID)));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                    @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex(COL_AUTHOR));
                    @SuppressLint("Range") String pages = cursor.getString(cursor.getColumnIndex(COL_PAGES));

                    Model model = new Model(id, name, author, pages);

                    arrData.add(model);
                }
            }

        return arrData;
    }

    public void update(String id, String name, String author, String pNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();


        val.put(COL_NAME, name);
        val.put(COL_AUTHOR, author);
        val.put(COL_PAGES, pNumber);

        long result = db.update(TABLE_NAME, val,  COL_ID + "=?", new String[]{id});
        
        if (result == -1){
            Toast.makeText(context, "Data Update Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Update Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}


