package com.example.infs3634;

import android.os.Parcel;
import android.os.Parcelable;

/*This is the java class for all the quiz questions utilising parcelable instead of default
serialization, as parcelable is faster. */

public class QuizQuestion implements Parcelable {

    //The relevant attributes to each question.
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;

    //Constructor
    public QuizQuestion() {

    }

    public QuizQuestion(String question, String option1, String option2, String option3, int answerNr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
    }

    protected QuizQuestion(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answerNr = in.readInt();
    }

    //Write to parcel method
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answerNr);
    }

    //Describing the contents which will then return 0.
    @Override
    public int describeContents() {
        return 0;
    }

    //Creator for the quiz questions.
    public static final Creator<QuizQuestion> CREATOR = new Creator<QuizQuestion>() {
        @Override
        public QuizQuestion createFromParcel(Parcel in) {
            return new QuizQuestion(in);
        }

        //Array based on questions size.
        @Override
        public QuizQuestion[] newArray(int size) {
            return new QuizQuestion[size];
        }
    };

    //Getters and Setters for each attribute to a question.
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
