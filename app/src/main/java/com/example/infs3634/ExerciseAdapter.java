package com.example.infs3634;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//This is the relevant java class for the exercise adapter.

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {
    public ArrayList<Exercise> myExercises;
    private RecyclerViewClickListener mListener;

    //Adapter constructor which takes in list, recycler list listener and a context for a button.
    public ExerciseAdapter(ArrayList<Exercise> elist, RecyclerViewClickListener listener) {
        myExercises = elist;
        mListener = listener;
    }

    // Detect the item clicked and interpret the click.
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    //Extending the ExerciseViewHolder with RecyclerViewHolder and implementing onClickListener.
    public static class ExerciseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, intensity, type;
        private RecyclerViewClickListener mListener;

        //Exercise viewHolder which will show name, intensity and type within the card.
        public ExerciseViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.tvExerciseName);
            intensity = v.findViewById(R.id.tvExerciseIntensity);
            type = v.findViewById(R.id.tvExerciseType);
        }

        //onClick for the item which is clicked and getting adapter position.
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    /*The onCreateViewHolder, in which the layout inflater for the view gets context from the
     exercise list xml file, defines the list utem layouts which will be inflated.*/
    @Override
    public ExerciseAdapter.ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_exercise_list, parent, false);
        return new ExerciseViewHolder(v, mListener);
    }

    // Replace the contents of a view (invoked by the layout manager), populating individual views.
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        Exercise ex = myExercises.get(position);
        holder.name.setText(ex.getName());
        holder.type.setText("Targets:" + ex.getType());
        holder.intensity.setText("Intensity: " + ex.getIntensity());

    }

    // Return the size of the dataset (invoked by the layout manager).
    public int getItemCount() {
        return myExercises.size();
    }

    /* Implementing (Dataset data) method for the adapter that updates the data during runtime so it
    could filter the dataset based on what button has been clicked.*/
    public void swap(ArrayList<Exercise> data) {
        myExercises.clear();
        myExercises.addAll(data);
        notifyDataSetChanged();
    }
}

