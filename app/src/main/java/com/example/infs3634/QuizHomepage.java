package com.example.infs3634;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*This is the java class for  for the quiz homepage activity, which users will enter when they click
 the quiz button in the main homepage.*/

public class QuizHomepage extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private int highscore;

    //setting layout of the activity and loading the high score.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_homepage);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        //Finding the resource for the start button for the quiz, and setting the listener and the onClick method.
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

        //This is for the back button, setting the listener and onClick to go back.
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Intent to start the quiz in the next activity which is the quizActivity.
    private void startQuiz() {
        Intent intent = new Intent(QuizHomepage.this, QuizActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);

    }

    //Getting results for the quiz, also for updating the highscore, if the results are higher than previous highscore.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    //Loading the new or current highscore on the quiz homepage.
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    //Update the highscore for the homepage if it is needed to be updated depending on the results.
    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();

    }
}
