package com.example.infs3634;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.infs3634.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/*This is the helper java class for the quiz database which utilises SQLite and has the data for the questions
for the quiz as well as the correct answers.*/

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create the database questions table with the relevant columns.
    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    //Dropping the table upon upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }
      /*The 10 questions for quiz, which includes the questions, multiple choices for answers and the correct
      answer */
    private void fillQuestionsTable() {
        QuizQuestion q1 = new QuizQuestion("Where are your hamstrings located?", "Thigh", "Chest", "Arms", 3);
        addQuestion(q1);
        QuizQuestion q2 = new QuizQuestion("What exercise helps improve stability, relieve backspin and enforce a neutral spine? ", "Bird dog", "Squats", "Arm Circles", 1);
        addQuestion(q2);
        QuizQuestion q3 = new QuizQuestion("Which one of the following is a cardiovascular exercise? ", "Planks", "Back extensions", "Mountain Climbers", 3);
        addQuestion(q3);
        QuizQuestion q4 = new QuizQuestion("What exercises are used to target your obliques?", "Bicycle Crunches", "Dips", "Squats", 1);
        addQuestion(q4);
        QuizQuestion q5 = new QuizQuestion("What is the pectoralis muscle?", "Muscle located in the upper chest", "Muscle located in the triceps", "Muscle located in glutes", 1);
        addQuestion(q5);
        QuizQuestion q6 = new QuizQuestion("What type of exercise is recommenced for losing body fat?", "Cardio", "Strength training", "Stretching", 1);
        addQuestion(q6);
        QuizQuestion q7 = new QuizQuestion("Which of the following is not a lower body exercise?", "Squat Jumps", "Lunges", "Arm Raises", 3);
        addQuestion(q7);
        QuizQuestion q8 = new QuizQuestion("What does ‘set’ mean in exercise terminology?", "A set is the setting in which the exercise is conducted", "A set is group of consecutive repetitions of an exercise", "A set is a fixed position of the exercise", 2);
        addQuestion(q8);
        QuizQuestion q9 = new QuizQuestion("Which of the following help strengthen your core?", "Up-down planks", "Bicycle crunches", "All of the above", 3);
        addQuestion(q9);
        QuizQuestion q10 = new QuizQuestion("Where is your Anterior Deltoid located?", "Shoulder", "Neck", "Back", 1);
        addQuestion(q10);


    }

    //Adding the questions for the quiz, utilising content values for each column within the table.
    private void addQuestion(QuizQuestion quizQuestion) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, quizQuestion.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, quizQuestion.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, quizQuestion.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, quizQuestion.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, quizQuestion.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);

    }

    //Getting all the questions for the quiz.
    public ArrayList<QuizQuestion> getAllQuestions() {
        ArrayList<QuizQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                QuizQuestion quizQuestion = new QuizQuestion();
                quizQuestion.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                quizQuestion.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                quizQuestion.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                quizQuestion.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                quizQuestion.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(quizQuestion);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
