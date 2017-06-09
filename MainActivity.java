package com.example.kaushik.song;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    MediaPlayer song;
    ProgressBar progressBar;
    NumberPicker possibilities;
    Switch switch_looping;
    Button okay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        okay = (Button)findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        possibilities = (NumberPicker)findViewById(R.id.numberPicker);
        String[] possibilitiesString = {
                "The night we met",
                "Something just like this",
                "Let Me Love You",
                "The Nights",
                "Far Over the Misty Mountains Cold",
                "Kwabs - Walk",
                "Closer",
                "Carnival of Rust",
                "Underdog",
                "Perfect",
                "Rush soundtrack",
                "Interstellar soundtrack",
                "Game of thrones",
                "Breaking bad",
                "Sherlock",
                "Pirates of the Carribean"

        };
        possibilities.setDisplayedValues(possibilitiesString);
        possibilities.setMinValue(0);
        possibilities.setMaxValue(possibilitiesString.length - 1);

        switch_looping = (Switch) findViewById(R.id.switch_looping);
        switch_looping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                song.setLooping(isChecked);
            }
        });
    }

    public void setSong(View v){
        int choice = possibilities.getValue();
        if (choice == 0){
            song = MediaPlayer.create(this, R.raw.nightwemet);
        }
        if (choice == 1){
            song = MediaPlayer.create(this, R.raw.somethingjustlikethis);
        }
        if (choice == 2){
            song = MediaPlayer.create(this, R.raw.letmeloveyou);
        }
        if (choice == 3){
            song = MediaPlayer.create(this, R.raw.thenights);
        }
        if (choice == 4){
            song = MediaPlayer.create(this, R.raw.hobbitsong);
        }
        if (choice == 5){
            song = MediaPlayer.create(this, R.raw.walk);
        }
        if (choice == 6){
            song = MediaPlayer.create(this, R.raw.closer);
        }
        if (choice == 7){
            song = MediaPlayer.create(this, R.raw.carnivalofrust);
        }
        if (choice == 8){
            song = MediaPlayer.create(this, R.raw.underdog);
        }
        if (choice == 9){
            song = MediaPlayer.create(this, R.raw.perfect);
        }
        if (choice == 10){
            song = MediaPlayer.create(this, R.raw.rush);
        }
        if (choice == 11){
            song = MediaPlayer.create(this, R.raw.interstellar);
        }
        if (choice == 12){
            song = MediaPlayer.create(this, R.raw.got);
        }
        if (choice ==13){
            song = MediaPlayer.create(this, R.raw.breakingbad);
        }
        if (choice == 14){
            song = MediaPlayer.create(this, R.raw.sherlock);
        }
        if (choice == 15){
            song = MediaPlayer.create(this, R.raw.pirate);
        }
        Toast.makeText(getApplicationContext(),"Song has been selected!! ", Toast.LENGTH_SHORT).show();
        toggleButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        switch_looping.setVisibility(View.VISIBLE);
        okay.setVisibility(View.INVISIBLE);
        progressBar.setProgress(0);
    }


    public void PlayPause(View v) {
        boolean checked = ((ToggleButton) v).isChecked();
        int duration = song.getDuration();
        int current = song.getCurrentPosition();
        if (checked) {
            song.start();
            progressBar.setProgress(current * 100/ duration);
            okay.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "The song duration is " + duration/60000 + " minutes", Toast.LENGTH_SHORT).show();
        } else {
            song.pause();
            progressBar.setProgress(current * 100 / duration);
            okay.setVisibility(View.VISIBLE);
        }
    }

}