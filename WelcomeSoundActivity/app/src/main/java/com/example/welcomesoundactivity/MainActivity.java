package com.example.welcomesoundactivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean firstLaunch = prefs.getBoolean("firstLaunch", true);

        if (firstLaunch) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.audio1);
            mp.start();
            prefs.edit().putBoolean("firstLaunch", false).apply();
        }


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new AudioFragment())
                .commit();
    }
}