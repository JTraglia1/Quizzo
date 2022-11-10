package com.hfad.quizzoapp;

import java.util.ArrayList;

public class Question {

    private String genre;
    private String question;
    private ArrayList<String> choices = new ArrayList<String>();
    private String answer;
    private String followUp;

    public Question()
    {
        genre = "";
        question = "";
        choices.add("");
        answer = "";
        followUp = "";
    }

    public Question(String g, String q, ArrayList<String> c, String a, String f)
    {
        genre = g;
        //System.out.println(genre);
        question = q;
        //System.out.println(question);

        for(int i = 0; i < c.size(); i++)
        {
            //System.out.println(c.get(i));
            choices.add(c.get(i));
        }
        answer = a;
        //System.out.println(answer);
        followUp = f;
        //System.out.println(followUp);
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
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }
}

