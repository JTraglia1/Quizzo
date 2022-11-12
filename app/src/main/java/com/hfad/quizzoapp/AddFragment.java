package com.hfad.quizzoapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment
{
    ArrayList<Question> questions;
    ArrayList<String> choices = new ArrayList<String>();
    ArrayList<String> quiz = new ArrayList<String>();

    String userAnswer = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        TextView etAddGenre = view.findViewById(R.id.etAddGenre);
        TextView etAddQuestion = view.findViewById(R.id.etAddQuestion);
        TextView etAddFirstChoice = view.findViewById(R.id.etAddFirstChoice);
        TextView etAddSecondChoice = view.findViewById(R.id.etAddSecondChoice);
        TextView etAddThirdChoice = view.findViewById(R.id.etAddThirdChoice);
        TextView etAddFourthChoice = view.findViewById(R.id.etAddFourthChoice);
        Spinner spnChoices = view.findViewById(R.id.spnChoices);
        TextView etFollowUpFact = view.findViewById(R.id.etFollowUpFact);
        Button btnAddUserQuestion = view.findViewById(R.id.btnAddUserQuestion);

        btnAddUserQuestion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if (!etAddFirstChoice.getText().toString().equals(""))
                {
                    choices.add(etAddFirstChoice.getText().toString());
                }
                if (!etAddSecondChoice.getText().toString().equals(""))
                {
                    choices.add(etAddSecondChoice.getText().toString());
                }
                if (!etAddThirdChoice.getText().toString().equals(""))
                {
                    choices.add(etAddThirdChoice.getText().toString());
                }
                if (!etAddFourthChoice.getText().toString().equals(""))
                {
                    choices.add(etAddFourthChoice.getText().toString());
                }

                else
                {
                    if (spnChoices.getSelectedItem().toString().equals("Choice 1"))
                    {
                        userAnswer = etAddFirstChoice.getText().toString();
                    }
                    else if (spnChoices.getSelectedItem().toString().equals("Choice 2"))
                    {
                        userAnswer = etAddSecondChoice.getText().toString();
                    }
                    else if (spnChoices.getSelectedItem().toString().equals("Choice 3"))
                    {
                        userAnswer = etAddThirdChoice.getText().toString();
                    }
                    else if (spnChoices.getSelectedItem().toString().equals("Choice 4"))
                    {
                        userAnswer = etAddFourthChoice.getText().toString();
                    }

                    questions = Database.createQuestion(etAddGenre.getText().toString(), etAddQuestion.getText().toString(), choices, userAnswer, etFollowUpFact.getText().toString());
                }

                String[] genres = getResources().getStringArray(R.array.spnGenres);

                for (int i = 0; i < genres.length; i++)
                {
                    System.out.println(genres[i]);
                }

                for (int i = 0; i < questions.size(); i++)
                {
                    quiz.add(questions.get(i).getGenre());
                }

                Navigation.findNavController(view).navigate(R.id.action_addFragment_to_addedFragment);
            }
        });

        return view;
    }
}