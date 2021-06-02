package com.example.fracku.samplesqldatabase;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import android.content.Context;
import android.content.ContentValues;

public class Handler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DatabaseFileName.db";

    public static final String TABLE_NAME = "Table Name";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "item1";

    public Handler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String Q = "CREATE TABLE " + TABLE_NAME + 
            "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTO INCREMENT " +
            COLUMN_NAME + " TEXT "+
            ");";
        db.execSQL(Q);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
        onCreate(db);
    }

    public void addentry(sqldata1 entry){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, entry.get_label1());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null,values);
        db.close();
    }
    public void delentry(String label1){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM"+TABLE_NAME+"WHERE"+COLUMN_NAME+ "=\""+label1+"\";");
    }
    public String dbtostring(){
        String dbStr = " ";
        SQLiteDatabase db = getWritableDatabase();
        String Q = "SELECT FROM"+TABLE_NAME+"WHERE 1";

        Cursor c = db.rawQuery(Q, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("label1"))!=null){
                dbStr += c.getString(c.getColumnIndex("item1"));
                dbStr += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbStr;
    }
}
