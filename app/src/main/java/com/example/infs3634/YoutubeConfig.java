package com.example.infs3634;


//This is the configuration java class for the Youtube activity which is in the resources section.

public class YoutubeConfig {

    public YoutubeConfig() {
    }

    // Our API key for the Youtube API.
    public static final String API_KEY = "AIzaSyCLWd97ppT1DWTr0aenHPXhLVC188CGbbQ";

    //Returning the API Key.
    public static String getAPIKey() {
        return API_KEY;
    }
}
