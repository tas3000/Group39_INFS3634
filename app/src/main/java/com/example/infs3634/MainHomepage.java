package com.example.infs3634;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*This java class is for the homepage of the application, which users will enter after they click the
button in the first activity. This will showcase the three sections; exercises, resources
and quiz.*/

public class MainHomepage extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //The buttons for the three sections.
    Button ExerciseButton;
    Button ResourceButton;
    Button QuizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Log.d(TAG, "onCreate: Starting");

        //Finding and setting up the resource id for the buttons for each section.
        ExerciseButton = (Button) findViewById(R.id.exerciseButton);
        ResourceButton = (Button) findViewById(R.id.resourcesButton);
        QuizButton = (Button) findViewById(R.id.quizButton);

       /*Below are the OnClickListeners and onClick method for each button to go to a different activity,
        which will be the relevant homepage for that section.*/

        //For the exercises section, setting the listener for on click to enter the next activity.
        ExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Exercise Button clicked");
                Intent intent = new Intent(MainHomepage.this, ExerciseHomepage.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Exercise intent launched");
            }
        });

        //For the resources section, setting the listener for on click to enter the next activity.
        ResourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Resource Button clicked");
                Intent intent = new Intent(MainHomepage.this, ResourcesHomepage.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Resource intent launched");
            }
        });

        //For the quiz section, setting the listener for on click to enter the next activity.
        QuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz Button clicked");
                Intent intent = new Intent(MainHomepage.this, QuizHomepage.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Quiz intent launched");
            }
        });

    }

}