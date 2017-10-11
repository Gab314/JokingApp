package com.example.jokinglibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gabriel.jokes.Joker;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class MainActivityLib extends AppCompatActivity {
    AdView adView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String flavor = intent.getStringExtra("Flavor");
        Joker joker = new Joker();
        final String joke = joker.getJoke();

        if (flavor.equals("Free")){
            setContentView(R.layout.activity_main_lib);
           button = (Button) findViewById(R.id.activity_main_btn);
        }
        if (flavor.equals("Paid")){
            setContentView(R.layout.activity_main_lib_paid);
            button = (Button) findViewById(R.id.activity_main_btn_paid);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke(joke);
            }
        });

        if (flavor.equals("Free")){
            adView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)// This is for emulators
                    .addTestDevice("FA5C3D05F5DDEC54A5BF17167DA7F124")
                    .build();
            adView.loadAd(adRequest);



            adView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    // Code to be executed when an ad finishes loading.
                    Log.i("Ads", "onAdLoaded");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    Log.i("Ads", "onAdFailedToLoad");
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                    Log.i("Ads", "onAdOpened");
                }

                @Override
                public void onAdLeftApplication() {
                    // Code to be executed when the user has left the app.
                    Log.i("Ads", "onAdLeftApplication");
                }

                @Override
                public void onAdClosed() {
                    // Code to be executed when when the user is about to return
                    // to the app after tapping on an ad.
                    Log.i("Ads", "onAdClosed");
                }
            });
        }
    }
    @Override
    protected void onPause() {
        if (adView != null) {
            adView.pause();
            super.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adView!=null){  // Check if Adview is not null in case of fist time load.
            adView.resume();}
    }

    public void tellJoke(String s) {
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this,s));
    }

}

