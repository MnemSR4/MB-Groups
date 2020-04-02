package com.example.e_exam_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.e_exam_database.ExamContract.*;
import static com.example.e_exam_database.ExamContract.*;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "exam";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       //create table bta3 levels
        String SQL_CREATE_TABLE_LEVELS ="CREATE TABLE IF NOT EXISTS " + LevelsEntry.TABLE_NAME +"(" +
                LevelsEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                LevelsEntry.COLUMN_NAME +" TEXT NOT NULL " +
                ");";

        //create table bta3 departments
        String SQL_CREATE_TABLE_DEPARTMENTS ="CREATE TABLE IF NOT EXISTS " + DepartmentEntry.TABLE_NAME +"(" +
                DepartmentEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                DepartmentEntry.COLUMN_NAME +" TEXT NOT NULL, " +
                DepartmentEntry.COLUMN_LEVEL_ID +" INTEGER NOT NULL, " +
                " FOREIGN KEY "+"(" +
                DepartmentEntry.COLUMN_LEVEL_ID +")" +
                " REFERENCES " +
                LevelsEntry.TABLE_NAME + "(" +
                LevelsEntry.COLUMN_ID + ")" +
                ");";

        db.execSQL(SQL_CREATE_TABLE_LEVELS);
        db.execSQL(SQL_CREATE_TABLE_DEPARTMENTS);

        Log.i("DBHelper", "database is created .......");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //method insert el levels
    public void addLevel(Level level) {

        ContentValues cv = new ContentValues();
        cv.put(LevelsEntry.COLUMN_NAME, level.getName());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(LevelsEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added....");
    }
    //method insert el dep
    public void addDepartment(Department department) {

        ContentValues cv = new ContentValues();
        cv.put(DepartmentEntry.COLUMN_NAME, department.getDepartment_name());
        cv.put(DepartmentEntry.COLUMN_LEVEL_ID, department.getLevel_id());


        SQLiteDatabase db = getWritableDatabase();
        db.insert(DepartmentEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added DEP....");
    }
    //method select levels (id,name)
    public List<Level> getAllLevels(){
        List<Level> levels =new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.query(LevelsEntry.TABLE_NAME,
                new String[]{LevelsEntry.COLUMN_ID,LevelsEntry.COLUMN_NAME},
                null,
                null,
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                levels.add(new Level(cursor.getInt(0),
                        cursor.getString(1)));
            }
            }
        return levels;
    }
   //method select dep (name , level_id)
    public List<Department> getAllDepartments(){
        List<Department> departments =new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.query(DepartmentEntry.TABLE_NAME,
                new String[]{DepartmentEntry.COLUMN_NAME,DepartmentEntry.COLUMN_LEVEL_ID},
                null,
                null,
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                departments.add(new Department(cursor.getString(0),
                        cursor.getInt(1)));
            }
        }
        return departments;
    }


}






