package com.gmail.androiddz.data.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.gmail.androiddz.data.dbentity.Country;
import com.gmail.androiddz.data.dbentity.User;

import java.util.ArrayList;

public class DatabaseManager {

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public void open(boolean isWritable) {
        if (isWritable) {
            database = dbHelper.getWritableDatabase();
        } else {
            database = dbHelper.getReadableDatabase();
        }
    }

    public void close() {
        if (database != null) {
            database.close();
        }
    }

    public void insertUser(User user) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO user ('name', 'age', 'countryId')");
        sql.append("VALUES (");
        sql.append("'");
        sql.append(user.getName());
        sql.append("', ");
        sql.append(user.getAge());
        sql.append(", ");
        sql.append(user.getCountry().getId());
        sql.append(")");

//        INSERT INTO user ('name', 'age', 'countryId') VALUES ('Name', 25, 0);


        Log.e("DatabaseManager", "insertUser() sql = " + sql.toString());
        database.execSQL(sql.toString());
    }

    public void updateUser(User user) {
    }

    public ArrayList<User> getUsers() {
        Cursor cursor = database.rawQuery("SELECT * FROM User", null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            ArrayList<User> list = new ArrayList<>();
            do {
                User user = new User();
                int i = cursor.getInt(cursor.getColumnIndex("id"));
                user.setId(i);
                user.setName(cursor.getString(1));
                list.add(user);
            } while (cursor.moveToNext());
            Log.e("Cursor", String.valueOf(list.size()));
            return list;
        } else {
            return null;
        }
    }

    public User getUserById(int id) {

        Cursor cursor = database.rawQuery("SELECT * FROM user INNER JOIN country ON " +
                        "user.countryId = country.id WHERE id = ?",
                new String[]{String.valueOf(id)});
//        Cursor cursor = database.rawQuery("SELECT * FROM user WHERE id = " + id, null);

        if (cursor != null) {
            User user = new User();

            //вытягиваем данные из Cursor
            cursor.moveToFirst();
            int userId = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String countryId = cursor.getString(3);
            String countryName = cursor.getString(4);

            //заполняем объект User
            user.setId(userId);
            user.setName(name);
            user.setAge(age);

            //заполняем объект Country
            Country country = new Country();
            country.setId(countryId);
            country.setName(countryName);

            //добавляем объект Country в User
            user.setCountry(country);

            return user;
        } else {
            Log.e("DatabaseManager", "getUserById() cursor is null");
        }
        return null;
    }

}
