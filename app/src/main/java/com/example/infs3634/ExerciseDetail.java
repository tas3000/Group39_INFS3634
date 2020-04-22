package com.example.infs3634;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/*This is the class for Exercise Details, which is the activity that users will see after
 they click an item to view details about a particular exercise.*/

public class ExerciseDetail extends AppCompatActivity {

    //All the relevant attributes which will be utilised for this activity.
    private Exercise mExercise;
    private TextView tvTime;
    private TextView tvIntensity;
    //private TextView tvType;
    private TextView tvName;
    private TextView tvDesc;
    private Button buttonVideo;
    private ImageView ivImage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        //Getting all the relevant resource ids from the xml file.
        tvName = findViewById(R.id.tvName);
        tvTime = findViewById(R.id.tvTime);
        tvIntensity = findViewById(R.id.tvIntensity);
        tvDesc = findViewById(R.id.tvDesc);
        ivImage = findViewById(R.id.ivImage);
        //tvType = findViewById(R.id.tvType);
        buttonVideo = findViewById(R.id.buttonVideo);

        Intent intent = getIntent();
        int position = intent.getIntExtra(ExerciseHomepage.EXTRA_MESSAGE, 0);

        //Retrieving and setting all the required attribute/details for the exercises onto the screen.
        mExercise = Exercise.exerciseDetail().get(position);
        setTitle(mExercise.getName());
        tvName.setText(mExercise.getName());
        //tvLevel.setText(mExercise.getLevel());
        tvDesc.setText("Description: " + mExercise.getDesc());
        tvIntensity.setText("Intensity: " + mExercise.getIntensity());
        tvTime.setText("Repetitions: " + mExercise.getTime());
        ivImage.setImageResource(mExercise.getImage());

        /*Setting an OnClickListener for when the user clicks the button to watch the video and the
         onClick method which will utilise the intent from the openVideo method*/
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVideo(mExercise.getLink());
            }
        });
    }

    /*Intent to open the relevant video to a specific video by getting the relevant link data
    from the exercise class.*/
    private void openVideo(String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}

