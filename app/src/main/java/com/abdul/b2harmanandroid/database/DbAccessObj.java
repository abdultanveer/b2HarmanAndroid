package com.abdul.b2harmanandroid.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.abdul.b2harmanandroid.database.FeedReaderContract.FeedEntry;

import com.abdul.b2harmanandroid.data.Item;

public class DbAccessObj {
    DbHelper dbHelper;
    SQLiteDatabase database;


    public DbAccessObj(Context context){
        dbHelper = new DbHelper(context);
    }

    public  void openDb(){
        database = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        database.close();
    }


    public void createRow(Note note){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,note.title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,note.subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    public void readRow(){}
    public void updateRow(){}
    public void deleteRow(){}
    public void readRows(){}
}
