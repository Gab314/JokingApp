package com.example.jokinglibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gabriel.jokes.Joker;


public class MainActivityLib extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lib);
        Button button = (Button) findViewById(R.id.activity_main_btn);

        Joker joker = new Joker();
        final String joke = joker.getJoke();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke(joke);
            }
        });


    }

    public void tellJoke(String s) {
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this,s));
    }



}

