package com.example.ee_exam.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ee_exam.Model.Professor;
import com.example.ee_exam.Model.Student;
import com.example.ee_exam.Model.User;

public class SqliteHelper extends SQLiteOpenHelper {


    //DATABASE NAME
    public static final String DATABASE_NAME = "UserManager.db";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    public SqliteHelper(Context context) {
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

        String SQL_TABLE_PROFESSORS = " CREATE TABLE " +DataProfesspor.TABLE_profssor
                + " ( "
                + DataProfesspor.KEY_ID + " INTEGER PRIMARY KEY, "
                + DataProfesspor.KEY_USER_NAME + " TEXT, "
                + DataProfesspor.KEY_EMAIL + " TEXT, "
                + DataProfesspor.KEY_SUBJECT + " TEXT, "
                + DataProfesspor.KEY_PASSWORD + " TEXT"
                + " ) ";



         // CREATE TABLE FOR STUDENT
        String SQL_TABLE_STUDENTS = " CREATE TABLE " + DataStudent.TABLE_STUDENTS
                + " ( "
                + DataStudent.KEY_ID + " INTEGER PRIMARY KEY, "
                + DataStudent.KEY_USER_NAME + " TEXT, "
                + DataStudent.KEY_EMAIL + " TEXT, "
                + DataStudent.KEY_PASSWORD + " TEXT,"

                +DataStudent.COLUMN_level + " TEXT, "

                + DataStudent.COLUMN_DEPARTMENT+ " TEXT "

                + ");";

        db.execSQL(SQL_TABLE_USERS);
        db.execSQL(SQL_TABLE_STUDENTS);
        db.execSQL(SQL_TABLE_PROFESSORS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " +Data.TABLE_USERS);
        onCreate(db);

        db.execSQL(" DROP TABLE IF EXISTS " +DataStudent.TABLE_STUDENTS);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " +DataProfesspor.TABLE_profssor);
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public void addStudent(Student student) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        //create content values to insert
        ContentValues values = new ContentValues();
        //Put username in  @values
        values.put(DataStudent.KEY_USER_NAME, student.userName);
        //Put email in  @values
        values.put(DataStudent.KEY_EMAIL, student.email);
        //Put password in  @values
        values.put(DataStudent.KEY_PASSWORD, student.password);

        values.put(DataStudent.COLUMN_level, student.getOption_level());

        values.put(DataStudent.COLUMN_DEPARTMENT, student.getOption_depatment());


        // insert row
        long todo_id = db.insert(DataStudent.TABLE_STUDENTS, null, values);
    }



   public Student SELCTED(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DataStudent.TABLE_STUDENTS,// Selecting Table
                new String[]{DataStudent.KEY_ID, DataStudent.KEY_USER_NAME, DataStudent.KEY_EMAIL, DataStudent.KEY_PASSWORD,
                DataStudent.COLUMN_level,
                DataStudent.COLUMN_DEPARTMENT,},//Selecting columns want to query
                DataStudent.KEY_EMAIL + "=?",
                new String[]{student.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            Student student1 = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getString(5));

            //Match both passwords check they are same or not
            if (student.password.equalsIgnoreCase(student1.password)) {
                return student1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }



    public boolean isStudEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DataStudent.TABLE_STUDENTS,// Selecting Table
                new String[]{DataStudent.KEY_ID, DataStudent.KEY_USER_NAME, DataStudent.KEY_EMAIL, DataStudent.KEY_PASSWORD,
                        DataStudent.COLUMN_level,
                        DataStudent.COLUMN_DEPARTMENT,},//Selecting columns want to query
                DataStudent.KEY_EMAIL + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public void addProfessor(Professor professor) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put(DataProfesspor.KEY_USER_NAME, professor.userName);

        //Put email in  @values
        values.put(DataProfesspor.KEY_EMAIL, professor.email);
        // subject
        values.put(DataProfesspor.KEY_SUBJECT, professor.email);

        //Put password in  @values
        values.put(DataProfesspor.KEY_PASSWORD, professor.password);

        // insert row
        long todo_id = db.insert(DataProfesspor.TABLE_profssor, null, values);
    }




    public Professor profAuthenticate(Professor professor) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DataProfesspor.TABLE_profssor,// Selecting Table
                new String[]{DataProfesspor.KEY_ID, DataProfesspor.KEY_USER_NAME, DataProfesspor.KEY_EMAIL,DataProfesspor.KEY_SUBJECT, DataProfesspor.KEY_PASSWORD},//Selecting columns want to query
                DataProfesspor.KEY_EMAIL + "=?",
                new String[]{professor.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            Professor professor1= new Professor(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));

            //Match both passwords check they are same or not
            if (professor.password.equalsIgnoreCase(professor1.password)) {
                return professor1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isProfEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DataProfesspor.TABLE_profssor,// Selecting Table
                new String[]{DataProfesspor.KEY_ID, DataProfesspor.KEY_USER_NAME, DataProfesspor.KEY_EMAIL,DataProfesspor.KEY_SUBJECT, DataProfesspor.KEY_PASSWORD},//Selecting columns want to query
                DataProfesspor.KEY_EMAIL + "=?",
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


