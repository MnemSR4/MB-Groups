package com.example.ptofessor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.ptofessor.Database.Data;

import java.util.ArrayList;
import java.util.List;

import static com.example.ptofessor.ExamContract.*;

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
                DepartmentEntry.COLUMN_LEVEL_ID +" INTEGER NOT NULL, FOREIGN KEY (" +
                DepartmentEntry.COLUMN_LEVEL_ID +") REFERENCES " +
                LevelsEntry.TABLE_NAME + "(" +
                LevelsEntry.COLUMN_ID + "));";

        //create table bta3 subjects
        String SQL_CREATE_TABLE_SUBJECTS ="CREATE TABLE IF NOT EXISTS " + SubjectEntry.TABLE_NAME + "(" +
                SubjectEntry.COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SubjectEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                SubjectEntry.COLUMN_ACCESS_CODE+" TEXT NOT NULL UNIQUE , "+
                SubjectEntry.COLUMN_DEPARTMENT_ID + " INTEGER NOT NULL, FOREIGN KEY (" +
                SubjectEntry.COLUMN_DEPARTMENT_ID + ")  REFERENCES " +
                DepartmentEntry.TABLE_NAME + "(" +
                DepartmentEntry.COLUMN_ID + "));";

        //create table bta3 result
        String SQL_CREATE_TABLE_RESULT ="CREATE TABLE IF NOT EXISTS " + ResultEntry.TABLE_NAME + "("+
                ResultEntry.COLUMN_STUDENT_ID +" INTEGER NOT NULL," +
                ResultEntry.COLUMN_SUBJECT_ACCESS_CODE +" INTEGER NOT NULL," +
                ResultEntry.COLUMN_MARKS + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" +
                ResultEntry.COLUMN_STUDENT_ID + ") REFERENCES "+
                Data.TABLE_USERS +"(" +
                Data.KEY_ID +")," +
                " FOREIGN KEY (" +
                ResultEntry.COLUMN_SUBJECT_ACCESS_CODE + ") REFERENCES "+
                SubjectEntry.TABLE_NAME + "(" +
                SubjectEntry.COLUMN_ACCESS_CODE +
                "));";

       //create table bta3 mcq question
        final String SQL_CREATE_TABLE_QUESTIONS = "CREATE TABLE IF NOT EXISTS " + QuestionEntry.TABLE_NAME + "(" +
                QuestionEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionEntry.COLUMN_QUESTION + " TEXT NOT NULL ," +
                QuestionEntry.COLUMN_OPTION_1 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_OPTION_2 + " TEXT NOT NULL ," +
                QuestionEntry.COLUMN_OPTION_3 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_OPTION_4 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL " +
                ");";
        //create table bta3 tf ques
        final String SQL_CREATE_TABLE_TRUE_FALSE_QUESTIONS = "CREATE TABLE IF NOT EXISTS " + TFQuestionEntry.TABLE_NAME + "(" +
                TFQuestionEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TFQuestionEntry.COLUMN_QUESTION+ " TEXT NOT NULL , " +
                TFQuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL " +
                ");";


        db.execSQL(SQL_CREATE_TABLE_LEVELS);
        db.execSQL(SQL_CREATE_TABLE_DEPARTMENTS);
        db.execSQL(SQL_CREATE_TABLE_SUBJECTS);
        db.execSQL(SQL_CREATE_TABLE_RESULT);
        db.execSQL(SQL_CREATE_TABLE_QUESTIONS);
        db.execSQL(SQL_CREATE_TABLE_TRUE_FALSE_QUESTIONS);
        Log.i("DBHelper", "database is created .......");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //insert mcq ques
    public void addQuestion(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionEntry.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionEntry.COLUMN_OPTION_1, question.getOption_1());
        cv.put(QuestionEntry.COLUMN_OPTION_2, question.getOption_2());
        cv.put(QuestionEntry.COLUMN_OPTION_3, question.getOption_3());
        cv.put(QuestionEntry.COLUMN_OPTION_4, question.getOption_4());
        cv.put(QuestionEntry.COLUMN_ANSWER, question.getAnswer());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(QuestionEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added2....");

    }


//select mcq ques
    public List<Question> getAllQes() {
        List<Question> questions = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_QUESTION, QuestionEntry.COLUMN_OPTION_1, QuestionEntry.COLUMN_OPTION_2, QuestionEntry.COLUMN_OPTION_3, QuestionEntry.COLUMN_OPTION_4, QuestionEntry.COLUMN_ANSWER},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null) {
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


    //insert tf ques
    public void addTFQuestion(TrueFalseQuestion trueFalseQuestion) {
        ContentValues cv = new ContentValues();
        cv.put(TFQuestionEntry.COLUMN_QUESTION, trueFalseQuestion.getQuestion());
        cv.put(TFQuestionEntry.COLUMN_ANSWER, trueFalseQuestion.getAnswer());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TFQuestionEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added3....");
    }


    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(QuestionEntry.TABLE_NAME,
                null,
                null);
        db.close();
        Log.i("DBHelper", "deleted....");
    }

}






