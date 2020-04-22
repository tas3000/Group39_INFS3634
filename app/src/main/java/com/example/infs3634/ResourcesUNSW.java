package com.example.infs3634;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*This is the java class for the UNSW resources activity which will have the unsw gym timetable and
have buttons that go to the unsw gym website and access the map location of the gym.*/

public class ResourcesUNSW extends AppCompatActivity {

    //The button for the map.
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_unsw);
        button = (Button) findViewById(R.id.mapButton);

        //Setting the listener and onClick method, to go to the API activity when the map button is clicked.
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ResourcesUNSW.this, ResourcesUNSWAPI.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

    //The intent utilised to open the unsw gym website, when the button is clicked to access the website.
    public void UNSW_Website(View view) {
        Intent UNSWIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.unsw-ymca.org.au/timetables/"));
        startActivity(UNSWIntent);
    }
}

