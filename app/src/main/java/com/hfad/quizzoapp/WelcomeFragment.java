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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        Button btnAdd = view.findViewById(R.id.MainMenu);
        Button btnQuiz = view.findViewById(R.id.buttonPractice);
        Spinner spnGenre = view.findViewById(R.id.Genres);

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String genre = spnGenre.getSelectedItem().toString();
                WelcomeFragmentDirections.ActionWelcomeFragmentToQuizFragment action =
                        WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment(genre);

                System.out.println(spnGenre.getSelectedItem().toString() + "Test");
                Navigation.findNavController(v).navigate(action);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.action_welcomeFragment_to_addFragment);
            }
        });

        return view;
    }
}