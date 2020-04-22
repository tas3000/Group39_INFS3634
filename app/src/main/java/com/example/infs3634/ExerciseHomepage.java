package com.example.infs3634;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*This is the java class for the Exercise Homepage which will have
the various target areas of exercises for the user to choose from.*/

//Note we were not able to filter the exercises by target area.

public class ExerciseHomepage extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "MESSAGE";

    //There will be a total of 6 buttons.
    Button buttonGlutes;
    Button buttonAbs;
    Button buttonArms;
    Button buttonLegs;
    Button buttonBack;
    Button buttonChest;

    /*Below are the listener and onClick methods for the buttons for each target area
    (6 areas-> abs, legs, arms, chest, back, glute). When a target area is clicked,
    this will lead to the filtered list of exercises for that specific target area.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_homepage);

        //This is for abs for the button, the listener and onClick method relevant to it.
        Button buttonAbs = findViewById(R.id.buttonAbs);
        buttonAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecyclerLayout.class);
                //getAbs();
                startActivity(intent);
            }

            ;

            /*This method should be recycler_layout.mAdapter.swap(exercise.filterExercises("ABS"));
            which should tell the adapter to: clear existing list of all exercises and instead swap
            it with the ones containing (for example) planks*/
            void getAbs() {
            }
        });

        //This is for glutes for the button, the listener and onClick method relevant to it.
        Button buttonGlutes = findViewById(R.id.buttonGlutes);
        buttonGlutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecyclerLayout.class);
                //getAbs();
                startActivity(intent);
            }

            ;

            void getAbs() {
            }
        });

        //This is for chest for the button, the listener and onClick method relevant to it.
        Button buttonChest = findViewById(R.id.buttonChest);
        buttonChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecyclerLayout.class);
                //getAbs();
                startActivity(intent);
            }

            ;

            void getAbs() {

            }
        });

        //This is for back for the button, the listener and onClick method relevant to it.
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecyclerLayout.class);
                //getAbs();
                startActivity(intent);
            }

            ;

            void getAbs() {
            }
        });

        //This is for legs for the button, the listener and onClick method relevant to it.
        Button buttonLegs = findViewById(R.id.buttonLegs);
        buttonLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecyclerLayout.class);
                //getAbs();
                startActivity(intent);
            }

            ;

            void getAbs() {
            }
        });

        //This is for arms for the button, the listener and onClick method relevant to it.
        Button buttonArms = findViewById(R.id.buttonArms);
        buttonArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecyclerLayout.class);
                //getAbs();
                startActivity(intent);
            }

            ;

            void getAbs() {
            }
        });
    }
}