package com.example.infs3634;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

//This is the java class for the quiz activity, for when the user is doing and completing the quiz.

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    //Relevant attributes
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<QuizQuestion> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private QuizQuestion currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    private ArrayList<String> mStringList = new ArrayList<>();
    private ArrayList<String> mAnswer = new ArrayList<>();
    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ArrayList<String> strListValue = SharedPrefsStrListUtil.getStrListValue(this, KEYS_QUESTIONS);
        Log.d(TAG, "onCreate: 111" + strListValue);
        SharedPrefsStrListUtil.removeStrList(this, KEYS_QUESTIONS);
        SharedPrefsStrListUtil.removeStrList(this, KEYS_ANSWER);

        ArrayList<String> strListValue1 = SharedPrefsStrListUtil.getStrListValue(this, KEYS_QUESTIONS);
        Log.d(TAG, "onCreate: 1112" + strListValue1);

        //Setting the layout utilising the resource ids from the xml file.
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        //Shuffling the questions from the questions database.
        if (savedInstanceState == null) {

            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList = dbHelper.getAllQuestions();
            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);

            showNextQuestion();

        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);

            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            //If not answered will start countdown, and will show solution if timer runs out.
            if (!answered) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }
        /*Setting listener and onClick method for button to go to next question,
        a toast message will show up, if the user tries to skip and not answer the question.*/
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });

    }

    /*Showcasing and setting the next question in the quiz and utilising a button confirmation for the next question.
    Also having the counter which showcases the number of answered questions.*/
    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            questionCounter++;

            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        } else {
            finishQuiz();
        }
    }

    //The timer for the countdown in terms of starting and finishing.
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    //Updating the timer for the countdown for each question, and it will turn red when time is running out.
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    //Checking if the answer is correct for the users selected answer, if not then the solution will be shown.
    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("Score: " + score);
        } else {
            String question = currentQuestion.getQuestion();
            int answerNr1 = currentQuestion.getAnswerNr();
            mStringList.add(question);

            mAnswer.add(currentQuestion.getAnswerNr() + "");
        }

        showSolution();

    }

    /*Showcase the solution to the user when they complete a question by utilising the colours
    black and white */
    private void showSolution() {
        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.WHITE);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.WHITE);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.WHITE);
                textViewQuestion.setText("Answer 3 is correct");
                break;
        }

        /*Button confirmations for going to the next question and finishing the quiz, which will
        showcase popup messages to the user.*/
        String s = mStringList.toString();
        Log.d(TAG, "showSolution: " + s);
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }

    }

    public static final String KEYS_QUESTIONS = "keys_question;";
    public static final String KEYS_ANSWER = "keys_answer;";

    /*End of the Quiz which will then go to the next activity to showcase the feedback utilising
    the Questions Details class. */
    private void finishQuiz() {
        //Intent resultIntent = new Intent();
        //resultIntent.putExtra(EXTRA_SCORE, score);
        //setResult(RESULT_OK, resultIntent);
        SharedPrefsStrListUtil.putStrListValue(this, KEYS_QUESTIONS, mStringList);
        SharedPrefsStrListUtil.putStrListValue(this, KEYS_ANSWER, mAnswer);
        Intent intent = new Intent(this, QuestionsDetailsActivity.class);
        intent.putExtra("score", String.valueOf(score));
        startActivity(intent);
        finish();
    }

    /*Method for if the back button is pressed, will also showcase toast message to confirm with the
    user if they really are trying to go back.*/
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    //onDestroy method, countdown will cancel.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    //onSaveInstanceState method.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);


    }
}
