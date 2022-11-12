package com.hfad.quizzoapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 *  AddedFragment.java - Quizzo
 *  This fragment displays that the user's question has been added to the database.
 *
 *  @author Joseph Traglia
 *
 */
public class AddedFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_added, container, false);

        Button btnReturnToHomeScreen = view.findViewById(R.id.btnAddQuestion);

        btnReturnToHomeScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_addedFragment_to_welcomeFragment);
            }
        });

        return view;
    }
}