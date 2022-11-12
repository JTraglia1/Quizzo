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
public class ScoreFragment extends Fragment
{
    int iterator = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_score, container, false);

        TextView tvAnswersCorrect = view.findViewById(R.id.tvWelcomeMessage);
        TextView tvPercentageCorrect = view.findViewById(R.id.tvPercentageCorrect);
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        Button btnReturn = view.findViewById(R.id.btnReturn);

        String[] answer = ScoreFragmentArgs.fromBundle(requireArguments()).getAnswers();

        for (int i = 0; i < answer.length; i++)
        {
            if (answer[i].equals("Correct"))
            {
                iterator++;
            }
        }

        tvAnswersCorrect.setText("Number Correct: " + iterator);

        double percentage = iterator * 1.0 / answer.length * 100;

        tvPercentageCorrect.setText("Percentage: " + percentage + "%");

        if (percentage > 70)
        {
            tvMessage.setText("Great Job!");
        }
        else if (percentage < 70)
        {
            tvMessage.setText("Better Luck Next Time!");
        }

        btnReturn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_scoreFragment_to_welcomeFragment);
            }
        });

        return view;
    }
}