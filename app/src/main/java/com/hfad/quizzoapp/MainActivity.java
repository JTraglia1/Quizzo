package com.hfad.quizzoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 *  MainActivity.java - Greetings
 *  This application possesses the ability to run on Android devices
 *  with an application programming interface (API) of at least 21.
 *
 *  @author Joseph Traglia
 *
 */
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}