package com.yehlock.pokemonchart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlDataBaseHelper extends SQLiteOpenHelper {
    private static final String dbName = "test.db";
    private static String dbPath =  "src/main/res/raw";
    private static final int dbVersion = 1;
    private static final String table = "1-100data";

    private final Context mContext;

    //pokedex data
    public static final String _id = "_id";
    public static final String sinnohID = "sinnohID";
    public static final String hisuiID = "hisuiID";
    public static final String enName = "enName";
    public static final String jpName = "jpName";
    public static final String zhName = "zhName";
    public static final String typeI = "typeI";
    public static final String typeII = "typeII";
    public static final String height = "height";
    public static final String weight = "weight";
    public static final String imgUrl = "imgUrl";

    public SqlDataBaseHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
        this.mContext = context;
    }
    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        String dbpath = dbPath + dbName;
        try {
            checkDB = SQLiteDatabase.openDatabase(dbpath,
                    null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            return false;
        }
        if (checkDB != null) {
            checkDB.close();
            return true;
        }
        return false;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
