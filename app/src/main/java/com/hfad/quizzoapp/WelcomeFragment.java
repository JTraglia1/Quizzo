package com.hfad.quizzoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        Button btnAddQuestion = view.findViewById(R.id.btnAddQuestion);
        Spinner spnGenres = view.findViewById(R.id.spnGenres);
        Button btnPracticeQuiz = view.findViewById(R.id.btnPracticeQuiz);

        btnAddQuestion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_addFragment);
            }
        });

        btnPracticeQuiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String genre = spnGenres.getSelectedItem().toString();
                WelcomeFragmentDirections.ActionWelcomeFragmentToQuizFragment action =
                        WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment(genre);

                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }
}