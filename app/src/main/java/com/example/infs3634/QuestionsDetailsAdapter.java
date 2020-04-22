package com.example.infs3634;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//This is the adapter java class for the Questions Details activity for the questions.

public class QuestionsDetailsAdapter extends RecyclerView.Adapter<QuestionsDetailsAdapter.ViewHolder> {

    private ArrayList<String> mList = new ArrayList<>();
    private ArrayList<String> mAnswer = new ArrayList<>();
    private Context mContext;

    public QuestionsDetailsAdapter(Context context, ArrayList<String> strListValue, ArrayList<String> answer) {
        this.mList = strListValue;
        this.mAnswer = answer;
        this.mContext = context;
    }

    //ViewHolder defining the list item layouts which will be inflated into the recyclerview.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Replacing the contents of a view.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = mList.get(position);
        String answer = mAnswer.get(position);

        holder.mTvTitle.setText(s);

        QuizDbHelper quizDbHelper = new QuizDbHelper(mContext);
        ArrayList<QuizQuestion> allQuestions = quizDbHelper.getAllQuestions();

        //This showcases the correct answer for each question.
        String question0 = allQuestions.get(0).getQuestion();
        String question1 = allQuestions.get(1).getQuestion();
        String question2 = allQuestions.get(2).getQuestion();
        String question3 = allQuestions.get(3).getQuestion();
        String question4 = allQuestions.get(4).getQuestion();
        String question5 = allQuestions.get(5).getQuestion();
        String question6 = allQuestions.get(6).getQuestion();
        String question7 = allQuestions.get(7).getQuestion();
        String question8 = allQuestions.get(8).getQuestion();
        String question9 = allQuestions.get(9).getQuestion();
        if (s.equals(question0)) {
            holder.mTvAnswer.setText("Arms");
        } else if (s.equals(question1)) {
            holder.mTvAnswer.setText("Bird dog");
        } else if (s.equals(question2)) {
            holder.mTvAnswer.setText("Mountain Climbers");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("Bicycle Crunches");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("Muscle located in the upper chest");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("Cardio");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("Arm Raises");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("A set is group of consecutive repetitions of an exercise");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("All of the above");
        } else if (s.equals(question3)) {
            holder.mTvAnswer.setText("Shoulder");
        }

        Log.d("YES", "Success：" + mList.toString() + ",909090:" + answer.toString());
    }

    // Return the size of the dataset (invoked by the layout manager).
    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        TextView mTvAnswer;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvAnswer = itemView.findViewById(R.id.tv_answer);
        }
    }
}
