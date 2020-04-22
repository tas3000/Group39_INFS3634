package com.example.infs3634;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//This is the java class for the recycler layout for exercises.

public class RecyclerLayout extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "MESSAGE";

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        mRecyclerView = findViewById(R.id.rList);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Create a new listener for the recycler view list.
        ExerciseAdapter.RecyclerViewClickListener listener = new ExerciseAdapter.RecyclerViewClickListener() {

            //on click of the listener ,a detail view will be launched based on its position
            @Override
            public void onClick(View view, int position) {
                launchDetailActivity(position);
            }
        };

        //The list data is contained in the exercise detail array list which displays all exercises.
        mAdapter = new ExerciseAdapter(Exercise.exerciseDetail(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    //The method for launching the detail activity for each exercise.
    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, ExerciseDetail.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

}



