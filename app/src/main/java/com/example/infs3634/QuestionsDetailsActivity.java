package com.example.infs3634;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/*This is the class for question details for the feedback on how
users did with the quiz, showcasing the number of correctly answered questions, the number of
questions the user got wrong and goes through questions which users got wrong.*/

/***************************************************************************************
 * NOTE ALL THE QUIZ RELATED PAGES UTILISE THIS VIDEO SERIES
 *    Title: Multiple Choice Quiz App with SQLite Integration Part 1 Series
 *    Author: Coding in Flow
 *    Date: Uploaded date -> Feb 12, 2018
 *    Code version: No Version Outlined
 *    Availability: https://www.youtube.com/watch?v=PiCZQg4mhBQ&feature=youtu.be
 *
 ***************************************************************************************/

public class QuestionsDetailsActivity extends AppCompatActivity {

    //The relevant attributes for this activity.
    private RecyclerView mRecyclerView;
    private ArrayList<String> mStrListValue;
    private static final String TAG = "QuestionsDetailsActivity";
    private ArrayList<String> mStringAnswer;
    private TextView mTvCorrect;
    private TextView mTvTotal;
    private TextView mTvShowInCorrect;
    private String mScore;

    /*Showcasing the feedback in terms of score and incorrectly answered questions including the correct
    answers for the incorrectly answered questions.*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_details);

        mScore = getIntent().getStringExtra("score");

        mRecyclerView = findViewById(R.id.recyclerView);
        mTvCorrect = findViewById(R.id.tv_correct);
        mTvTotal = findViewById(R.id.tv_total);
        mTvShowInCorrect = findViewById(R.id.tv_show_incorrect);

        /*After the users views the feedback, they can click the back button to go back,
        as a finish. Setting the listener and the onClick method for the back button.*/
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    /*Finding and showcasing the number of incorrectly answered questions to the users as feedback, and also through
    showcasing the question and the correct answer for it, which will be in a list utilising string answer and list value.*/
    private void init() {
        mStrListValue = SharedPrefsStrListUtil.getStrListValue(this, QuizActivity.KEYS_QUESTIONS);
        mStringAnswer = SharedPrefsStrListUtil.getStrListValue(this, QuizActivity.KEYS_ANSWER);

        QuizDbHelper quizDbHelper = new QuizDbHelper(this);
        ArrayList<QuizQuestion> allQuestions = quizDbHelper.getAllQuestions();
        int size = allQuestions.size();
        int size1 = mStrListValue.size();
        if (!TextUtils.isEmpty(mScore)) {
            mTvCorrect.setText(mScore);
        }

        if (size > 0) {
            mTvTotal.setText(String.valueOf(size));
        } else {
            mTvTotal.setText(size);
        }
        mTvShowInCorrect.setText("INCORRECT ANSWERS：" + size1);

        /*The layout manager and recycler view which will be utilised to showcase the incorrectly
        answered questions, and the correct answer for it, which will be in a list.*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        QuestionsDetailsAdapter questionsDetailsAdapter = new QuestionsDetailsAdapter(this, mStrListValue, mStringAnswer);
        mRecyclerView.setAdapter(questionsDetailsAdapter);
    }
}
