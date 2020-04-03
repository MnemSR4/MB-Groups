package com.example.e_exam_database;

public class ExamContract {

    public static class LevelsEntry{

        public static final String TABLE_NAME = "levels";
        public static final String COLUMN_ID = "level_id";
        public static final String COLUMN_NAME = "level_name";
    }

    public static class DepartmentEntry{

        public static final String TABLE_NAME = "departments";
        public static final String COLUMN_ID = "department_id";
        public static final String COLUMN_NAME = "department_name";
        public static final String COLUMN_LEVEL_ID = "level_id";
    }

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

    public static class TFQuestionEntry{
        public static final String TABLE_NAME = "trueFalseQuestions";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_QUESTION = "trueFalseQuestion";
        public static final String COLUMN_OPTION_1 = "option_true";
        public static final String COLUMN_OPTION_2 = "option_false";
        public static final String COLUMN_ANSWER = "answer";

    }
}
