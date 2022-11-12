package com.hfad.quizzoapp;

import android.view.View;
import java.util.ArrayList;

/**
 *  Database.java - Quizzo
 *  This class houses the database of questions.
 *
 *  @author Joseph Traglia
 *
 */
public class Database extends Question
{
    private static ArrayList<Question> questions;

    public static ArrayList<Question> createQuestion(String genre, String question, ArrayList<String> choices, String answer, String followUpFact)
    {
        if (questions == null)
        {
            addQuestion();
        }
        else
        {
            questions.add(new Question(genre, question, choices, answer, followUpFact));
        }

        return questions;
    }

    private static void addQuestion()
    {
        questions = new ArrayList<Question>();

        ArrayList<String> questionChoices = new ArrayList<String>();
        questionChoices.add("Pacific");
        questionChoices.add("Atlantic");
        questionChoices.add("Arctic");
        questionChoices.add("Indian");
        questions.add(new Question("Geography", "Which ocean is the largest?", questionChoices, "Pacific", "The Pacific Ocean stretches to an astonishing 63.8 million square miles!"));
        questionChoices.clear();

        questionChoices.add("192");
        questionChoices.add("195");
        questionChoices.add("193");
        questionChoices.add("197");
        questions.add(new Question("Geography", "How many countries are in the world?", questionChoices, "195", "Africa has the most countries of any continent with 54."));
        questionChoices.clear();

        questionChoices.add("Mississippi");
        questionChoices.add("Nile");
        questionChoices.add("Congo");
        questionChoices.add("Amazon");
        questions.add(new Question("Geography", "What is the name of the longest river in the world?", questionChoices, "Nile", "Explorer John Hanning Speke discovered the source of the Nile on August 3rd, 1858."));
        questionChoices.clear();

        questionChoices.add("United States");
        questionChoices.add("China");
        questionChoices.add("Japan");
        questionChoices.add("India");
        questions.add(new Question("Geography", "Which country has the largest population?", questionChoices, "China", "Shanghai is the most populated city in China with a population of 24,870,895."));
        questionChoices.clear();

        questionChoices.add("Mars");
        questionChoices.add("Mercury");
        questionChoices.add("Venus");
        questionChoices.add("Jupiter");
        questions.add(new Question("Geography", "Which planet is closest to Earth?", questionChoices, "Venus", "Even though Venus is the closest, the planet it still ~38 million miles from Earth!"));
        questionChoices.clear();

        questionChoices.add("Sega");
        questionChoices.add("Nintendo");
        questionChoices.add("Sony");
        questionChoices.add("Atari");
        questions.add(new Question("Video Games", "Which company created the famous plumber Mario?", questionChoices, "Nintendo", "Nintendo created Mario in 1981 for the arcade game Donkey Kong."));
        questionChoices.clear();

        questionChoices.add("Sonic");
        questionChoices.add("Tails");
        questionChoices.add("Knuckles");
        questionChoices.add("Amy");
        questions.add(new Question("Video Games", "What is the name of the famous video character who is a blue hedgehog?", questionChoices, "Sonic", "In some official concept art, Sonic was originally meant to be a rabbit."));
        questionChoices.clear();

        questionChoices.add("Wii Sports");
        questionChoices.add("Grand Theft Auto V");
        questionChoices.add("Tetris");
        questionChoices.add("Minecraft");
        questions.add(new Question("Video Games", "As of 2022, which of the following is the best selling video game of all time?", questionChoices, "Minecraft", "As of 2022, Minecraft has sold over 238 million units."));
        questionChoices.clear();

        questionChoices.add("Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.");
        questionChoices.add("Place 2 milk, 3 sugar, 2 eggs, and 3 wheat in the 3x3 crafting grid.");
        questionChoices.add("Place 3 milk, 5 sugar, 6 eggs, and 3 wheat in the 3x6 crafting grid.");
        questionChoices.add("Place 1 milk, 1 sugar, 1 egg, and 1 wheat in the 1x1 crafting grid.");
        questions.add(new Question("Video Games", "How do you craft a cake in Minecraft?", questionChoices, "Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.", "Cake is the only food that has to be placed for players to eat it."));
        questionChoices.clear();

        questionChoices.add("Diddy Kong");
        questionChoices.add("Donkey Kong Jr.");
        questionChoices.add("Dixie Kong");
        questionChoices.add("Papa Kong");
        questions.add(new Question("Video Games", "Who is Donkey Kong’s son?", questionChoices, "Donkey Kong Jr", "Donkey Kong Jr. has appeared only in the game Super Mario Kart for Super Nintendo Entertainment System as a playable character celebrating the 10th anniversary of his arcade game and his shared history with Mario."));
        questionChoices.clear();

        questionChoices.add("1");
        questionChoices.add("5");
        questionChoices.add("4");
        questionChoices.add("10");
        questions.add(new Question("Video Games", "How many Xenoblade Chronicles have been created?", questionChoices, "5", "Xenoblade Chronicles was originally going to be titled Monado: Beginning of the World and was not intended as an entry into the Xeno series."));
        questionChoices.clear();

        questionChoices.add("Black");
        questionChoices.add("White");
        questionChoices.add("Pink");
        questionChoices.add("Brown");
        questions.add(new Question("Animals", "What colour is a polar bear’s skin?", questionChoices, "Black", "Polar bear fur is actually hollow and transparent!"));
        questionChoices.clear();

        questionChoices.add("Man-o-war");
        questionChoices.add("Box jellyfish");
        questionChoices.add("Irukandji Jellyfish");
        questionChoices.add("Sea Nettle");
        questions.add(new Question("Animals", "Which jellyfish has the deadliest sting?", questionChoices, "Irukandji Jellyfish", "Some jellyfish species are functionally immortal."));
        questionChoices.clear();

        questionChoices.add("True");
        questionChoices.add("False");
        questions.add(new Question("Animals", "Hyenas scavenge more than lions do.", questionChoices, "False", "Lions actually scavenge for food more than they hunt it."));
        questionChoices.clear();

        questionChoices.add("Grizzly bear");
        questionChoices.add("Polar bear");
        questionChoices.add("Raccoon");
        questionChoices.add("Cat");
        questionChoices.add("Spectacled bear");
        questions.add(new Question("Animals", "What is the giant panda’s closest relative?", questionChoices, "Spectacled bear", "Despite common belief, molecular studies show that pandas are in fact closer to bears than raccoons."));
        questionChoices.clear();

        questionChoices.add("Hippo");
        questionChoices.add("Sloth");
        questionChoices.add("Bats");
        questionChoices.add("Elk");
        questionChoices.add("Fish");
        questions.add(new Question("Animals", "Which one of these animals cannot swim?", questionChoices, "Hippo", "Hippos are the world’s most dangerous land mammal."));
        questionChoices.clear();

        questionChoices.add("Eagles");
        questionChoices.add("Packers");
        questionChoices.add("Cowboys");
        questionChoices.add("76ers");
        questionChoices.add("Ravens");
        questions.add(new Question("Sports", "Who won the first superbowl in NFL history?", questionChoices, "Packers", "The Packers have won the NFL championship 4 times."));
        questionChoices.clear();

        questionChoices.add("1");
        questionChoices.add("2");
        questionChoices.add("Infinite");
        questionChoices.add("7");
        questionChoices.add("3");
        questions.add(new Question("Sports", "How many NFL teams play in New Jersey and New York?", questionChoices, "3", "The Giants and Jets both play in New Jersey, but are New York based. The Buffalo Bills are the only team that actually plays in New York."));
        questionChoices.clear();

        questionChoices.add("50");
        questionChoices.add("100");
        questionChoices.add("75");
        questionChoices.add("60");
        questions.add(new Question("Sports", "How many points did Kobe Bryant score in his last NBA game?", questionChoices, "60", "Kobe scored over 60 five times during his career."));
        questionChoices.clear();

        questionChoices.add("28");
        questionChoices.add("7");
        questionChoices.add("23");
        questionChoices.add("13");
        questions.add(new Question("Sports", "How many gold medals has Michael Phelps been awarded in his olympic career?", questionChoices, "23", "Michael Phelps is the most successful olympian for owning the most medals and most gold medals of any athlete."));
        questionChoices.clear();

        questionChoices.add("Michael Jordan");
        questionChoices.add("Magic Johnson");
        questionChoices.add("Bill Russell");
        questionChoices.add("LeBron James");
        questions.add(new Question("Sports", "What player has the most NBA Championships in NBA History?", questionChoices, "Bill Russell", "Bill Russell won the NBA championship 11 times in his career!"));
        questionChoices.clear();

        questionChoices.add("Venus Williams");
        questionChoices.add("Roger Federer");
        questionChoices.add("Rafael Nadal");
        questionChoices.add("Serena Williams");
        questionChoices.add("Novak Djokovic");
        questions.add(new Question("Sports", "Who has earned more Grand Slam single titles during the open era in tennis.", questionChoices, "Serena Williams", "Serena and Her Sister Venus won 14 Grand Slam Doubles titles and three doubles gold medals at the Olympics."));
        questionChoices.clear();
    }

    public static ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public static ArrayList<String> getGenre(String genre)
    {
        ArrayList<String> specificGenre = new ArrayList<String>();

        for (int i = 0; i < questions.size(); i++)
        {
            if (questions.get(i).getGenre().equals(genre))
            {
                specificGenre.add(questions.get(i).getGenre());
            }
        }
        return specificGenre;
    }
}