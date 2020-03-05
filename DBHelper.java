package com.example.ee_exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

import static com.example.ee_exam.ExamContract.*;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "exam";
    public static final int DATABASE_VERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_TABLE_STUDENTS ="CREATE TABLE IF NOT EXISTS " + StudentEntry.TABLE_NAME + "(" +
                StudentEntry.COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                StudentEntry.COLUMN_NAME +" TEXT NOT NULL " +
                ");";

        final String SQL_CREATE_TABLE_QUESTIONS ="CREATE TABLE IF NOT EXISTS " + QuestionEntry.TABLE_NAME + "(" +
                QuestionEntry.COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionEntry.COLUMN_QUESTION +" TEXT NOT NULL ," +
                QuestionEntry.COLUMN_OPTION_1 +" TEXT NOT NULL , "+
                QuestionEntry.COLUMN_OPTION_2 +" TEXT NOT NULL ," +
                QuestionEntry.COLUMN_OPTION_3 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_OPTION_4 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL " +
                ");";


        db.execSQL(SQL_CREATE_TABLE_STUDENTS);
        db.execSQL(SQL_CREATE_TABLE_QUESTIONS);
        Log.i("DBHelper" ,"database is created .......");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent (Student student){

        ContentValues cv =new ContentValues();
        cv.put(StudentEntry.COLUMN_NAME,student.getName());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(StudentEntry.TABLE_NAME ,null ,cv);
        db.close();
        Log.i("DBHelper" , "added....");
    }

    public void addQuestion (Question question){

        ContentValues cv =new ContentValues();
        cv.put(QuestionEntry.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionEntry.COLUMN_OPTION_1,question.getOption_1());
        cv.put(QuestionEntry.COLUMN_OPTION_2,question.getOption_2());
        cv.put(QuestionEntry.COLUMN_OPTION_3,question.getOption_3());
        cv.put(QuestionEntry.COLUMN_OPTION_4,question.getOption_4());
        cv.put(QuestionEntry.COLUMN_ANSWER,question.getAnswer());

        SQLiteDatabase db =getWritableDatabase();
        db.insert(QuestionEntry.TABLE_NAME , null ,cv);
        db.close();
        Log.i("DBHelper" , "added2....");

    }

    public List<Question> getAllQes (){
        List<Question> questions = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(QuestionEntry.TABLE_NAME ,
                new String[]{ QuestionEntry.COLUMN_QUESTION,QuestionEntry.COLUMN_OPTION_1 ,QuestionEntry.COLUMN_OPTION_2,QuestionEntry.COLUMN_OPTION_3,QuestionEntry.COLUMN_OPTION_4,QuestionEntry.COLUMN_ANSWER},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null ){
            while (cursor.moveToNext()) {
                questions.add(new Question(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)));

            }
        }

        return questions;
    }
    public void deleteAll (){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(QuestionEntry.TABLE_NAME,
                null,
                null);
        db.close();
        Log.i("DBHelper" , "deleted....");
    }


    public ArrayList<String> getAllAnswers(){
        ArrayList<String> answers = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();

        Cursor cursor =db.query(QuestionEntry.TABLE_NAME,
               new String[]{QuestionEntry.COLUMN_ANSWER} ,
                null,
                null,
                null,
                null,
                null);


        if (cursor != null){
            while (cursor.moveToNext()) {
                answers.add(cursor.getString(0));
            }
        }



        return answers;
    }


    public ArrayList<String> getOption_1(){
        ArrayList<String> options_1 = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor =db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_OPTION_1},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                options_1.add(cursor.getString(0));
            }
        }
        return options_1;
    }



    public ArrayList<String> getOption_2(){
        ArrayList<String> options_2 = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor =db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_OPTION_2},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                options_2.add(cursor.getString(0));
            }
        }
        return options_2;
    }


    public ArrayList<String> getOption_3(){
        ArrayList<String> options_3 = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor =db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_OPTION_3},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                options_3.add(cursor.getString(0));
            }
        }
        return options_3;
    }

    public ArrayList<String> getOption_4(){
        ArrayList<String> options_4 = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor =db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_OPTION_4},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                options_4.add(cursor.getString(0));
            }
        }
        return options_4;
    }


        public ArrayList<String> getAllQestions(){
            ArrayList<String> questions = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor =db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_QUESTION},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                questions.add(cursor.getString(0));
            }
        }
        return questions;
    }

    public ArrayList<String> getAllNames(){
        ArrayList<String> names = new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor =db.query(StudentEntry.TABLE_NAME,
                new String[]{StudentEntry.COLUMN_NAME},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                names.add(cursor.getString(0));
            }
        }
        return names;
    }


}
