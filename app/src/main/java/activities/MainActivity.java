package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gabriel.jokingapp.R;
import com.example.jokinglibrary.MainActivityLib;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchLibraryActivity();
    }

    public void launchLibraryActivity() {
        Intent myIntent = new Intent(this, MainActivityLib.class);
        myIntent.putExtra("Flavor","Free");
        startActivity(myIntent);
    }
}
