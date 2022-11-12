package com.hfad.quizzoapp;

import java.util.ArrayList;

/**
 *  Question.java - Greetings
 *  This class contains the parameters for a user to add a question.
 *
 *  @author Joseph Traglia
 *
 */
public class Question {

    private String genre;
    private String question;
    private ArrayList<String> choices = new ArrayList<String>();
    private String answer;
    private String followUpFact;

    public Question()
    {
        genre = "";
        question = "";
        choices.add("");
        answer = "";
        followUpFact = "";
    }

    public Question(String gen, String ques, ArrayList<String> userChoices, String answ, String fact)
    {
        genre = gen;
        question = ques;

        for (int i = 0; i < userChoices.size(); i++)
        {
            choices.add(userChoices.get(i));
        }

        answer = answ;
        followUpFact = fact;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFollowUp() {
        return followUpFact;
    }

    public void setFollowUp(String followUp) {
        this.followUpFact = followUp;
    }
}

