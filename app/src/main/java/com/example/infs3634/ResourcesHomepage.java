package com.example.infs3634;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/***************************************************************************************
 *    Title: Facebook Login for Android - Quickstart
 *    Author:Facebook for Developers
 *    Date: Unknown, but states 2020
 *    Code version: No Version Outlined
 *    Availability: https://developers.facebook.com/docs/facebook-login/android?sdk=maven
 *
 ***************************************************************************************/

/*This is the java class for the resources homepage activity, which will showcase and include buttons for
three sections; video, unsw and facebook share.*/

public class ResourcesHomepage extends AppCompatActivity {
    private static final String TAG = "ResourceActivity";

    Button VideoButton;
    Button UNSWButton;
    Button Button;
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the layout utilising the relevant xml file.
        setContentView(R.layout.activity_resources_homepage);
        Log.d(TAG, "onCreate: Starting");

        /*Finding the correct resource id for each button. */
        VideoButton = (Button) findViewById(R.id.videoButton);
        UNSWButton = (Button) findViewById(R.id.unswButton);

        /*Below is setting up onClickListeners and the onClick method for the resource buttons
        for the unsw button and the video button,to go to a new activity when clicked. */

        //Listener to go to the relevant next activity which is video, note that the onClick has been set up in the xml file.
        VideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Video Button clicked");
                Intent intent = new Intent(ResourcesHomepage.this, ResourcesVideo.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Video intent launched");
            }
        });

        //Listener to go to the relevant next activity which is unsw, note that the onClick has been set up in the xml file.
        UNSWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: UNSW Button clicked");
                Intent intent = new Intent(ResourcesHomepage.this, ResourcesUNSW.class);
                startActivity(intent);
                Log.d(TAG, "onClick: UNSW intent launched");
            }
        });

        //Sharing via facebook button onClick and login utilising callback manager.
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        info = findViewById(R.id.tvInfo);
        loginButton = findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            //For onSuccess login result
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText("User ID: " + loginResult.getAccessToken().getUserId() + "\n" + "Auth Token: " + loginResult.getAccessToken().getToken());
            }

            //Cancelling login attempt message
            @Override
            public void onCancel() {
                info.setText("Login attempt cancelled.");
            }

            //Login attempt failed message
            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }
        });
    }

    //onActivityResult method for facebook share option.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}