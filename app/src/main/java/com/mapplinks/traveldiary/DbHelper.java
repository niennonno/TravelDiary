package com.mapplinks.traveldiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;

import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Aditya Vikram on 9/25/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TravelDiary.db";
    public static final int DATABASE_VERSION = 1;
    public static final String MEMORIES_TABLE = "memories";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_NOTES = "notes";
    public static final String COLUMN_ID = "_id";

    private static DbHelper singleton=null;

    public synchronized static DbHelper getInstance(Context context){
        if (singleton==null){
            singleton= new DbHelper(context.getApplicationContext());
        }
        return singleton;
    }

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+MEMORIES_TABLE+" ("
                +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_LATITUDE +" DOUBLE, "
                +COLUMN_LONGITUDE +" DOUBLE, "
                +COLUMN_CITY +" TEXT, "
                +COLUMN_COUNTRY +" TEXT, "
                +COLUMN_NOTES +" TEXT"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+MEMORIES_TABLE);
        onCreate(db);
    }
}
