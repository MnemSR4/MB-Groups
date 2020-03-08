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

        final String SQL_CREATE_TABLE_STUDENTS = "CREATE TABLE IF NOT EXISTS " + StudentEntry.TABLE_NAME + "(" +
                StudentEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                StudentEntry.COLUMN_NAME + " TEXT NOT NULL " +
                ");";

        final String SQL_CREATE_TABLE_QUESTIONS = "CREATE TABLE IF NOT EXISTS " + QuestionEntry.TABLE_NAME + "(" +
                QuestionEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionEntry.COLUMN_QUESTION + " TEXT NOT NULL ," +
                QuestionEntry.COLUMN_OPTION_1 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_OPTION_2 + " TEXT NOT NULL ," +
                QuestionEntry.COLUMN_OPTION_3 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_OPTION_4 + " TEXT NOT NULL , " +
                QuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL " +
                ");";

        final String SQL_CREATE_TABLE_TRUE_FALSE_QUESTIONS = "CREATE TABLE IF NOT EXISTS " + TFQuestionEntry.TABLE_NAME + "(" +
                TFQuestionEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TFQuestionEntry.COLUMN_QUESTION+ " TEXT NOT NULL , " +
                TFQuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL " +
                ");";


        db.execSQL(SQL_CREATE_TABLE_STUDENTS);
        db.execSQL(SQL_CREATE_TABLE_QUESTIONS);
        db.execSQL(SQL_CREATE_TABLE_TRUE_FALSE_QUESTIONS);
        Log.i("DBHelper", "database is created .......");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(Student student) {

        ContentValues cv = new ContentValues();
        cv.put(StudentEntry.COLUMN_NAME, student.getName());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(StudentEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added....");
    }

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

    public void addTFQuestion(TrueFalseQuestion trueFalseQuestion) {
        ContentValues cv = new ContentValues();
        cv.put(TFQuestionEntry.COLUMN_QUESTION, trueFalseQuestion.getQuestion());
        cv.put(TFQuestionEntry.COLUMN_ANSWER, trueFalseQuestion.getAnswer());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TFQuestionEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added3....");
    }

    public List<TrueFalseQuestion> getAllTFQes(){
        List<TrueFalseQuestion> trueFalseQuestions = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TFQuestionEntry.TABLE_NAME,
                new String[]{TFQuestionEntry.COLUMN_QUESTION, TFQuestionEntry.COLUMN_ANSWER},
                null,
                null,
                null,
                null,
                null);

        if (cursor != null){
            while (cursor.moveToNext()) {
                trueFalseQuestions.add(new TrueFalseQuestion(
                        cursor.getString(0),
                        cursor.getString(1)));

            }
        }
        return trueFalseQuestions;
    }

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

    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(QuestionEntry.TABLE_NAME,
                null,
                null);
        db.close();
        Log.i("DBHelper", "deleted....");
    }

}






