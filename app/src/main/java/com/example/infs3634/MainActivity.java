package com.example.infs3634;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
/*This is the class for the first activity which users will see when they open and launch
the application. Then when they click the button they will enter the homepage. */

public class MainActivity extends AppCompatActivity {

    //The button to go to the homepage activity.
    ImageButton myMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the button resource, listener and the onClick method for entering the homepage activity when the button is clicked.
        myMainButton = (ImageButton) findViewById(R.id.mainButton);
        myMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, MainHomepage.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
