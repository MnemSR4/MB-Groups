package com.example.ee_exam;

public class ExamContract {
    public static class StudentEntry{

        public static final String TABLE_NAME = "students";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }

    public static class QuestionEntry{

        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION_1 = "option_1";
        public static final String COLUMN_OPTION_2 = "option_2";
        public static final String COLUMN_OPTION_3 = "option_3";
        public static final String COLUMN_OPTION_4 = "option_4";
        public static final String COLUMN_ANSWER = "answer";


    }
}
