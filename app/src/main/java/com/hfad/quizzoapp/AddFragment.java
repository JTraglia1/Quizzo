package com.hfad.quizzoapp;

import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    private ArrayList<Question> quest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        Spinner spinnerChoices = view.findViewById(R.id.SpinnerChoices);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        TextView Genre = view.findViewById(R.id.Genre);
        TextView followUp = view.findViewById(R.id.FollowUpFact);
        TextView Question = view.findViewById(R.id.Text);
        TextView answer1 = view.findViewById(R.id.choice1);
        TextView answer2 = view.findViewById(R.id.choice2);
        TextView answer3 = view.findViewById(R.id.choice3);
        TextView answer4 = view.findViewById(R.id.choice4);


        ArrayList<String> choices = new ArrayList<String>();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!answer1.getText().toString().equals(""))
                {
                    choices.add(answer1.getText().toString());
                }
                if(!answer2.getText().toString().equals(""))
                {
                    choices.add(answer2.getText().toString());
                }
                if(!answer3.getText().toString().equals(""))
                {
                    choices.add(answer3.getText().toString());
                }
                if(!answer4.getText().toString().equals(""))
                {
                    choices.add(answer4.getText().toString());
                }

                if(choices.contains("")) {
                    //Need an if statement to stop if not enough info provided.
                }
                else
                {
                    String chosenAnswer = "";
                    if(spinnerChoices.getSelectedItem().toString().equals("Choice 1"))
                    {
                        chosenAnswer = answer1.getText().toString();
                    }
                    else if(spinnerChoices.getSelectedItem().toString().equals("Choice 2"))
                    {
                        chosenAnswer = answer2.getText().toString();
                    }
                    else if(spinnerChoices.getSelectedItem().toString().equals("Choice 3"))
                    {
                        chosenAnswer = answer3.getText().toString();
                    }
                    else if(spinnerChoices.getSelectedItem().toString().equals("Choice 4"))
                    {
                        chosenAnswer = answer4.getText().toString();
                    }

                    quest = Database.setData(Genre.getText().toString(), followUp.getText().toString(), Question.getText().toString(), choices, chosenAnswer);
                }

                String newGenre = Genre.getText().toString();

                String[] genres = getResources().getStringArray(R.array.Genres);

                for(int i = 0; i < genres.length; i++)
                {
                    System.out.println(genres[i]);
                }

                ArrayList<String> test = new ArrayList<String>();
                for(int i = 0; i < quest.size(); i++)
                {
                    test.add(quest.get(i).getGenre());
                }




                //List<String> genres = new ArrayList<String>(); = Database.getGenres()
                //ArrayAdapter<String> adapter;
                //view.getContext().getApplicationContext()
                //adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_single_choice, genres);
                //genres.add(adapter);

                Navigation.findNavController(v).navigate(R.id.action_addFragment_to_addedFragment);
            }
        });

        return view;
    }
}