package com.example.jokinglibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gabriel.jokes.Joker;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class MainActivityLib extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main_lib);
        Button button = (Button) findViewById(R.id.activity_main_btn);
        Intent intent = getIntent();

        String flavor = intent.getStringExtra("Flavor");
        Joker joker = new Joker();
        final String joke = joker.getJoke();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke(joke);
            }
        });

        if (flavor.equals("Free")){
            AdView adView = new AdView(this);
            adView.setAdSize(AdSize.BANNER);
            adView.setAdUnitId(getResources().getString(R.string.ad_unit_ID));
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice("FA5C3D05F5DDEC54A5BF17167DA7F124")
                    .build();
            adView.loadAd(adRequest);
        }
    }

    public void tellJoke(String s) {
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this,s));
    }

}

