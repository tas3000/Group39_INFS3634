package com.example.infs3634;

import android.provider.BaseColumns;

//This is the contract java class for the quiz.

public final class QuizContract {

    // Constructor
    private QuizContract() {

    }

    //the table name and the columns for the question table.
    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}
