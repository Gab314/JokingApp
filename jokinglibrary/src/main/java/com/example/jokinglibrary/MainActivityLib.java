package com.example.jokinglibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.gabriel.jokes.Joker;


public class MainActivityLib extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));


        Joker joker = new Joker();
        joker.getJoke();
    }

    public void tellJoke(View view) {
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }



}

