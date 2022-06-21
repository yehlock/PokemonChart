package com.yehlock.pokemonchart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private SqlDataBaseHelper sqlDataBaseHelper;

    public DatabaseManager(Context context){
        this.context = context;
    }

    public DatabaseManager open() throws SQLException{
        this.sqlDataBaseHelper = new SqlDataBaseHelper(this.context);
        this.sqLiteDatabase = this.sqlDataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        this.sqlDataBaseHelper.close();
    }

    public void insert(String name, String desc){

    }

    public Cursor fetch(){
        Cursor cursor = this.sqLiteDatabase.query(sqlDataBaseHelper.table, null, ContentValues);
    }
}
