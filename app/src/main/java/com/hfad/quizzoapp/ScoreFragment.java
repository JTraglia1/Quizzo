package com.hfad.quizzoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    int counter = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_score, container, false);

        TextView tvCorrect = view.findViewById(R.id.NumCorrect);
        TextView tvPercent = view.findViewById(R.id.PercentCorrect);
        Button btnReturn = view.findViewById(R.id.btnReturn);
        String[] answer = ScoreFragmentArgs.fromBundle(requireArguments()).getAnswers();

        for(int i = 0; i < answer.length; i++)
        {
            if(answer[i].equals("Correct"))
            {
                counter++;
            }
        }

        tvCorrect.setText("Number Correct: " + counter);
        tvPercent.setText("Percentage: " + (counter * 1.0 / answer.length) * 100 + "%");

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_scoreFragment_to_welcomeFragment);
            }
        });


        return view;
    }
}