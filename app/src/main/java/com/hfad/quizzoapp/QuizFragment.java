package com.hfad.quizzoapp;

import static com.hfad.quizzoapp.Database.getQuestions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment
{
    int questionNum = 0;
    int count = 0;
    Boolean isPressed = true;
    String selectedAnswer = "";

    ArrayList<String> answers = new ArrayList<String>();
    ArrayList<Question> questions = getQuestions();
    ArrayList<Question> genreQuestions = new ArrayList<Question>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        TextView tvGenreSelected = view.findViewById(R.id.tvGenreSelected);
        TextView tvCurrentQuestionNumber = view.findViewById(R.id.tvCurrentQuestionNumber);
        TextView tvQuizQuestion = view.findViewById(R.id.tvQuizQuestion);
        RadioGroup rgChoices = view.findViewById(R.id.rgChoices);
        RadioButton rbFirstChoice = view.findViewById(R.id.rbFirstChoice);
        RadioButton rbSecondChoice = view.findViewById(R.id.rbSecondChoice);
        RadioButton rbThirdChoice = view.findViewById(R.id.rbThirdChoice);
        RadioButton rbFourthChoice = view.findViewById(R.id.rbFourthChoice);
        RadioButton rbFifthChoice = view.findViewById(R.id.rbFifthChoice);
        Button btnNextQuestion = view.findViewById(R.id.btnNextQuestion);

        String genre = QuizFragmentArgs.fromBundle(requireArguments()).getChoice();

        for (int i = 0; i < questions.size();i++)
        {
            if (questions.get(i).getGenre().equals(genre))
            {
                count++;
                genreQuestions.add(questions.get(i));
            }
        }

        isPressed = false;

        retrieveQuestionsWithGenre(rbFirstChoice, rbSecondChoice, rbThirdChoice, rbFourthChoice, rbFifthChoice, genreQuestions, genre,
                                   tvGenreSelected, tvCurrentQuestionNumber, tvQuizQuestion);

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbFirstChoice.isChecked())
                {
                    selectedAnswer = rbFirstChoice.getText().toString();
                }
                if (rbSecondChoice.isChecked())
                {
                    selectedAnswer = rbSecondChoice.getText().toString();
                }
                if (rbThirdChoice.isChecked())
                {
                    selectedAnswer = rbThirdChoice.getText().toString();
                }
                if (rbFourthChoice.isChecked())
                {
                    selectedAnswer = rbFourthChoice.getText().toString();
                }
                if (rbFifthChoice.isChecked())
                {
                    selectedAnswer = rbFifthChoice.getText().toString();
                }

                if (selectedAnswer.equals(genreQuestions.get(questionNum).getAnswer()))
                {
                    Toast.makeText(getActivity(),"Correct!",Toast.LENGTH_SHORT).show();
                    answers.add("Correct");
                    Toast.makeText(getActivity(), questions.get(questionNum).getFollowUp(),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(),"Incorrect!",Toast.LENGTH_SHORT).show();
                    answers.add("Incorrect");
                    Toast.makeText(getActivity(), questions.get(questionNum).getFollowUp(),Toast.LENGTH_LONG).show();
                }

                questionNum += 1;
                isPressed = true;

                System.out.println(questionNum + "" + count);
                if(questionNum == count || questionNum == 0)
                {
                    QuizFragmentDirections.ActionQuizFragmentToScoreFragment action =
                            QuizFragmentDirections.actionQuizFragmentToScoreFragment(answers.toArray(new String[answers.size()]));

                    Navigation.findNavController(view).navigate(action);
                }
                else
                {
                    retrieveQuestionsWithGenre(rbFirstChoice, rbSecondChoice, rbThirdChoice, rbFourthChoice, rbFifthChoice, genreQuestions, genre,
                                               tvGenreSelected, tvCurrentQuestionNumber, tvQuizQuestion);
                }
            }
        });

        return view;
    }

    public void retrieveQuestionsWithGenre(RadioButton rbFirstChoice, RadioButton rbSecondChoice, RadioButton rbThirdChoice, RadioButton rbFourthChoice,
                                           RadioButton rbFifthChoice, ArrayList<Question> genreQuestions, String genre,
                                           TextView tvGenreSelected, TextView tvCurrentQuestionNumber, TextView tvQuizQuestion)
    {
        System.out.println(genreQuestions.get(questionNum).getGenre() + "-" + genre);
        tvCurrentQuestionNumber.setText("Question #" + (questionNum + 1));
        tvQuizQuestion.setText(genreQuestions.get(questionNum).getQuestion());
        tvGenreSelected.setText(genre);

        for (int i = 0; i < genreQuestions.get(questionNum).getChoices().size(); i++)
        {
            if (!genreQuestions.get(questionNum).getChoices().get(i).equals(""))
            {
                if (i == 0)
                {
                    rbFirstChoice.setEnabled(true);
                    rbFirstChoice.setText(genreQuestions.get(questionNum).getChoices().get(0));
                    rbFirstChoice.setVisibility(View.VISIBLE);
                }
                else if (i != 0 && i < 0)
                {
                    rbFirstChoice.setEnabled(false);
                    rbFirstChoice.setText("");
                    rbFirstChoice.setVisibility(View.INVISIBLE);
                }

                if (i == 1)
                {
                    rbSecondChoice.setEnabled(true);
                    rbSecondChoice.setText(genreQuestions.get(questionNum).getChoices().get(1));
                    rbSecondChoice.setVisibility(View.VISIBLE);
                }
                else if (i != 1 && i < 1)
                {
                    rbSecondChoice.setEnabled(false);
                    rbSecondChoice.setText("");
                    rbSecondChoice.setVisibility(View.INVISIBLE);
                }

                if (i == 2)
                {
                    rbThirdChoice.setEnabled(true);
                    rbThirdChoice.setText(genreQuestions.get(questionNum).getChoices().get(2));
                    rbThirdChoice.setVisibility(View.VISIBLE);
                }
                else if (i != 2 && i < 2)
                {
                    rbThirdChoice.setEnabled(false);
                    rbThirdChoice.setText("");
                    rbThirdChoice.setVisibility(View.INVISIBLE);
                }
                if (i == 3)
                {
                    rbFourthChoice.setEnabled(true);
                    rbFourthChoice.setText(genreQuestions.get(questionNum).getChoices().get(3));
                    rbFourthChoice.setVisibility(View.VISIBLE);

                }
                else if (i != 3 && i < 3)
                {
                    rbFourthChoice.setEnabled(false);
                    rbFourthChoice.setText("");
                    rbFourthChoice.setVisibility(View.INVISIBLE);
                }

                if (i == 4)
                {
                    rbFifthChoice.setEnabled(true);
                    rbFifthChoice.setText(genreQuestions.get(questionNum).getChoices().get(4));
                    rbFifthChoice.setVisibility(View.VISIBLE);

                }
                else if (i != 4 && i < 4)
                {
                    rbFifthChoice.setEnabled(false);
                    rbFifthChoice.setText("");
                    rbFifthChoice.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
}