package com.example.ee_exam.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ee_exam.Model.User;
import com.example.ee_exam.Model.User;

public class SqliteHelper extends SQLiteOpenHelper {


    //DATABASE NAME
    public static final String DATABASE_NAME = "UserManager.db";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    public SqliteHelper( Context context) {
        super(context, DATABASE_NAME,   null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String SQL_TABLE_USERS = " CREATE TABLE " + Data.TABLE_USERS
                + " ( "
                + Data.KEY_ID + " INTEGER PRIMARY KEY, "
                + Data.KEY_USER_NAME + " TEXT, "
                + Data.KEY_EMAIL + " TEXT, "
                + Data.KEY_PASSWORD + " TEXT"
                + " ) ";

        db.execSQL(SQL_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " +Data.TABLE_USERS);
        onCreate(db);

    }


    public void addUser(User user) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put(Data.KEY_USER_NAME, user.userName);

        //Put email in  @values
        values.put(Data.KEY_EMAIL, user.email);

        //Put password in  @values
        values.put(Data.KEY_PASSWORD, user.password);

        // insert row
        long todo_id = db.insert(Data.TABLE_USERS, null, values);
    }




    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Data.TABLE_USERS,// Selecting Table
                new String[]{Data.KEY_ID, Data.KEY_USER_NAME, Data.KEY_EMAIL, Data.KEY_PASSWORD},//Selecting columns want to query
                Data.KEY_EMAIL + "=?",
                new String[]{user.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Data.TABLE_USERS,// Selecting Table
                new String[]{Data.KEY_ID, Data.KEY_USER_NAME, Data.KEY_EMAIL, Data.KEY_PASSWORD},//Selecting columns want to query
                Data.KEY_EMAIL + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }

}
