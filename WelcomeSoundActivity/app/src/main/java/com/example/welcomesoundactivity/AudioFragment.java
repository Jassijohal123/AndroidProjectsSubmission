package com.example.welcomesoundactivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AudioFragment extends Fragment {

    public AudioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.audio_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Make sure these IDs match your XML layout
        Button btnAudio1 = view.findViewById(R.id.btnAudio1);
        ImageView imageView = view.findViewById(R.id.imageView);

        btnAudio1.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.audio1);
            mp.start();
            imageView.setImageResource(R.drawable.image1);
        });
    }
}