package com.gmail.androiddz.data.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test";
    private static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DBHelper", "onCreate()");

//        db.beginTransaction();  //при ошибке любой из операции транзакции все изменения
//        db.endTransaction();    //откатываются до начала транзакции (beginTransaction())

        db.execSQL("CREATE TABLE user " +
                "('id' INTEGER PRIMARY KEY, " +
                "'name' TEXT, " +
                "'age' INTEGER, " +
                "'countryId' TEXT)");

        db.execSQL("CREATE TABLE country " +
                "('id' TEXT PRIMARY KEY, " +
                "'name' TEXT)");

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO user ('name', 'age', 'countryId')");
        sql.append("VALUES (");
        sql.append("'");
        sql.append("Artyom");
        sql.append("', ");
        sql.append(24);
        sql.append(", '");
        sql.append("by");
        sql.append("')");
        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("DBHelper", "onUpgrade()");
    }

}
