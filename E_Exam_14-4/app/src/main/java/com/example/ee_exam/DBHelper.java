package com.example.ee_exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


import com.example.ee_exam.DatabaseRegestration.Data;

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
                SubjectEntry.COLUMN_EXAM_TIME +" INTEGER NOT NULL ," +
                SubjectEntry.COLUMN_DEPARTMENT_ID + " INTEGER NOT NULL, FOREIGN KEY (" +
                SubjectEntry.COLUMN_DEPARTMENT_ID + ")  REFERENCES " +
                DepartmentEntry.TABLE_NAME + "(" +
                DepartmentEntry.COLUMN_ID + "));";

        //create table bta3 result
        String SQL_CREATE_TABLE_RESULT ="CREATE TABLE IF NOT EXISTS " + ResultEntry.TABLE_NAME + "("+
                ResultEntry.COLUMN_STUDENT_NAME +" TEXT NOT NULL ," +
                ResultEntry.COLUMN_SUBJECT_ACCESS_CODE +" TEXT NOT NULL," +
                ResultEntry.COLUMN_MARKS + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" +
                ResultEntry.COLUMN_STUDENT_NAME + ") REFERENCES "+
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
                QuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL ," +
                QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE + " TEXT NOT NULL ,"+
                " FOREIGN KEY (" +
                QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE + ") REFERENCES "+
                SubjectEntry.TABLE_NAME + "(" +
                SubjectEntry.COLUMN_ACCESS_CODE +
                "));";
        //create table bta3 tf ques
        final String SQL_CREATE_TABLE_TRUE_FALSE_QUESTIONS = "CREATE TABLE IF NOT EXISTS " + TFQuestionEntry.TABLE_NAME + "(" +
                TFQuestionEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TFQuestionEntry.COLUMN_QUESTION+ " TEXT NOT NULL , " +
                TFQuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL ," +
                TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE+" TEXT NOT NULL ," +
                " FOREIGN KEY (" +
                TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE + ") REFERENCES "+
                SubjectEntry.TABLE_NAME + "(" +
                SubjectEntry.COLUMN_ACCESS_CODE +
                "));";



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

    //method insert  to table subjects
    public void addSubject(Subject subject) {

        ContentValues cv = new ContentValues();
        cv.put(SubjectEntry.COLUMN_NAME, subject.getName());
        cv.put(SubjectEntry.COLUMN_ACCESS_CODE, subject.getAccess_code());
        cv.put(SubjectEntry.COLUMN_DEPARTMENT_ID, subject.getDepartment_id());
        cv.put(SubjectEntry.COLUMN_EXAM_TIME, subject.getExamTime());


        SQLiteDatabase db = getWritableDatabase();
        db.insert(SubjectEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added subject....");
    }

    //method insert el result
    public void addResult(Result result) {

        ContentValues cv = new ContentValues();
        cv.put(ResultEntry.COLUMN_SUBJECT_ACCESS_CODE, result.getSubject_access_code());
        cv.put(ResultEntry.COLUMN_MARKS, result.getMarks());


        SQLiteDatabase db = getWritableDatabase();
        db.insert(ResultEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added result....");
    }

    //insert mcq ques about access code
    public void addQuestion(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE,question.getSubject_access_code());
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

    //insert true false ques about access code
    public void addTFQuestion(TrueFalseQuestion trueFalseQuestion) {
        ContentValues cv = new ContentValues();
        cv.put(TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE, trueFalseQuestion.getSubject_access_code());
        cv.put(TFQuestionEntry.COLUMN_QUESTION, trueFalseQuestion.getQuestion());
        cv.put(TFQuestionEntry.COLUMN_ANSWER, trueFalseQuestion.getAnswer());


        SQLiteDatabase db = getWritableDatabase();
        db.insert(TFQuestionEntry.TABLE_NAME, null, cv);
        db.close();
        Log.i("DBHelper", "added3....");
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

    //method select subject (name , access_code , dep_id)
    public List<Subject> getAllSubjects(){
        List<Subject> subjects =new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.query(SubjectEntry.TABLE_NAME,
                new String[]{SubjectEntry.COLUMN_NAME,SubjectEntry.COLUMN_ACCESS_CODE,SubjectEntry.COLUMN_DEPARTMENT_ID,SubjectEntry.COLUMN_EXAM_TIME},SubjectEntry.COLUMN_EXAM_TIME,
                null,
                null,
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                subjects.add(new Subject(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)));
            }
        }
        return subjects;
    }

    //method select exam time
    public int getExamTime(String accessCode){
        int examTime = 0;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.query(SubjectEntry.TABLE_NAME,
                new String[]{SubjectEntry.COLUMN_EXAM_TIME},
                SubjectEntry.COLUMN_ACCESS_CODE +"=?",
                new String[]{accessCode},
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                examTime =(cursor.getInt(0));
            }
        }
        return examTime;
    }

    //method select result (student_name , subject_access_code , marks)
    public List<Result> getAllResult(){
        List<Result> results =new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.query(ResultEntry.TABLE_NAME,
                new String[]{ResultEntry.COLUMN_STUDENT_NAME ,ResultEntry.COLUMN_SUBJECT_ACCESS_CODE,ResultEntry.COLUMN_MARKS},
                null,
                null,
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                results.add(new Result(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2)));
            }
        }
        return results;
    }
//search student abut name
    public List<Result> getAllResultById(String name){
        List<Result> resultList =new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.query(ResultEntry.TABLE_NAME,
                new String[]{ResultEntry.COLUMN_SUBJECT_ACCESS_CODE,ResultEntry.COLUMN_MARKS},
                ResultEntry.COLUMN_STUDENT_NAME +"=?",
                new String[]{name},
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                resultList.add(new Result(cursor.getString(0),
                        cursor.getInt(1)));
            }
        }
        return resultList;
    }

//select tf ques
    public List<TrueFalseQuestion> getAllTFQes(String subject_access_code){
        List<TrueFalseQuestion> trueFalseQuestions = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TFQuestionEntry.TABLE_NAME,
                new String[]{TFQuestionEntry.COLUMN_QUESTION, TFQuestionEntry.COLUMN_ANSWER},
                TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE +"=?",
                new String[]{subject_access_code},
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

//select mcq ques
    public List<Question> getAllQes(String subject_access_code) {
        List<Question> questions = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(QuestionEntry.TABLE_NAME,
                new String[]{QuestionEntry.COLUMN_QUESTION, QuestionEntry.COLUMN_OPTION_1, QuestionEntry.COLUMN_OPTION_2, QuestionEntry.COLUMN_OPTION_3, QuestionEntry.COLUMN_OPTION_4, QuestionEntry.COLUMN_ANSWER},
                QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE +"=?",
                new String[]{subject_access_code},
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
//delete all mcq
    public void deleteAllMCQ(String access_code) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(QuestionEntry.TABLE_NAME,
                QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE +"=?",
                new String[]{access_code});
        db.close();
        Log.i("DBHelper", "deleted....");
    }
//delete all true false
    public void deleteAllTF(String access_code) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TFQuestionEntry.TABLE_NAME,
                TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE + "+?",
                new String[]{access_code});
        db.close();
        Log.i("DBHelper", "deleted....");
    }


    public void deleteQues(String access ,String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(QuestionEntry.TABLE_NAME ,
               QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE + "=? AND " +QuestionEntry.COLUMN_ID +"=?",
                new String[]{access,id});
    }

    public void deleteTureFalseQuestion(String access ,String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TFQuestionEntry.TABLE_NAME ,
                TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE + " =? AND "+ TFQuestionEntry.COLUMN_ID +"=?" ,
                new String[]{access ,id});
    }
    ////////editting////////////

    public void updateQuestion(String access ,String id ,String question , String option1 ,String option2, String option3,String option4 ,String answer){
        SQLiteDatabase db =getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(QuestionEntry.COLUMN_QUESTION ,question );
        cv.put(QuestionEntry.COLUMN_OPTION_1 ,option1 );
        cv.put(QuestionEntry.COLUMN_OPTION_2 ,option2 );
        cv.put(QuestionEntry.COLUMN_OPTION_3 ,option3 );
        cv.put(QuestionEntry.COLUMN_OPTION_4 ,option4 );

        cv.put(QuestionEntry.COLUMN_ANSWER ,answer );
        db.update(QuestionEntry.TABLE_NAME,
                cv,
                QuestionEntry.COLUMN_SUBJECT_ACCESS_CODE +" =? AND " + QuestionEntry.COLUMN_ID+ "=?" ,
                new String[]{access , id});
    }

    public void updateLevel(String id , String levelName)
    {
        SQLiteDatabase db =getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LevelsEntry.COLUMN_NAME,levelName);
        db.update(LevelsEntry.TABLE_NAME,
                cv,
                LevelsEntry.COLUMN_ID + "=?",
                new String[]{id});
    }

    public void updateDepartment(String id , String deptName)
    {
        SQLiteDatabase db =getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LevelsEntry.COLUMN_NAME,deptName);
        db.update(LevelsEntry.TABLE_NAME,
                cv,
                LevelsEntry.COLUMN_ID + "=?",
                new String[]{id});
    }

    ////update for true false


    public void updateTrueandfalseQuestion(String access_code, String id,String question, String answer){
        SQLiteDatabase db =getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TFQuestionEntry.COLUMN_QUESTION ,question );
        cv.put(TFQuestionEntry.COLUMN_ANSWER ,answer );
        db.update(TFQuestionEntry.TABLE_NAME,
                cv,
                TFQuestionEntry.COLUMN_SUBJECT_ACCESS_CODE +" =? AND " + TFQuestionEntry.COLUMN_ID + "=?" ,
                new String[]{access_code,id});
    }


    ////update exam time


    public void updateExamTime(String accessCode ,int examTime){
        SQLiteDatabase db =getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SubjectEntry.COLUMN_EXAM_TIME ,examTime );
        db.update(SubjectEntry.TABLE_NAME,
                cv,
                SubjectEntry.COLUMN_ACCESS_CODE + "=?" ,
                new String[]{accessCode});
    }

    // udate to table subject

    public void updateSubject(String id ,String name , String acess_code ,String exame_time){
        SQLiteDatabase db =getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SubjectEntry.COLUMN_DEPARTMENT_ID ,id);
        cv.put(SubjectEntry.COLUMN_NAME ,name);
        cv.put(SubjectEntry.COLUMN_ACCESS_CODE ,acess_code );
        cv.put(SubjectEntry.COLUMN_EXAM_TIME,exame_time);

        db.update(SubjectEntry.TABLE_NAME,
                cv,
                SubjectEntry.COLUMN_ACCESS_CODE + "=?" ,
                new String[]{acess_code});



    }


}






