package com.abdul.b2harmanandroid.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.abdul.b2harmanandroid.database.FeedReaderContract.FeedEntry;

import com.abdul.b2harmanandroid.data.Item;

public class DbAccessObj {
    int a = 10;
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
    public String readRow(){
     //  Cursor resultCursor = database.rawQuery("select * from entry",null);
        Cursor resultsCursor =
                database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        int titleIndex = resultsCursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE); //1
        int subTitleIndex = resultsCursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);//2
        resultsCursor.moveToLast(); //pointing to the last row that was inserted int he db
        String title = resultsCursor.getString(titleIndex);
        String subtitle = resultsCursor.getString(subTitleIndex);
        return title +"\n"+ subtitle;
    }
    public void updateRow(){}
    public void deleteRow(){}
    public Cursor readRows(){
        Cursor resultCursor = database.rawQuery("select * from entry",null);
        return resultCursor;
    }
}
