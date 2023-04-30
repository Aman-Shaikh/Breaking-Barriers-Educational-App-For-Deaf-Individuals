package com.example.first;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TextTosign extends AppCompatActivity {

    EditText modelEditText;
    VideoView videoView;
    ImageView imageView;
    Button btn;
    int video_counter = 0;
    ArrayList<String> videoPathList;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_tosign);

        videoView = findViewById(R.id.modelVideoView);
        imageView = findViewById(R.id.mdelimage);
        modelEditText = findViewById(R.id.modelText);
        btn = findViewById(R.id.modelBtn);
        getSupportActionBar().hide();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = modelEditText.getText().toString();
                text = "";

                for (int i = 0; i < temp.length(); i++) {
                    if ((temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z') || (temp.charAt(i) >= '0' && temp.charAt(i) <= '9')) {
                        text = text + temp.charAt(i);
                    }
                }

                if (text.length() == 0) {
                    showToast("Please Enter Characters and Numbers");
                    imageView.setVisibility(View.VISIBLE);
                }
                else {
                    video_counter = 0;
                    int id = getResources().getIdentifier("a" + text.charAt(0), "raw", getPackageName());
                    videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            imageView.setVisibility(View.GONE);
                            videoView.start();
                        }
                    });
                    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            video_counter++;
                            if (video_counter != text.length()) {
                                int nextId = getResources().getIdentifier("a" + text.charAt(video_counter), "raw", getPackageName());
                                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + nextId));
                                videoView.start();
                            } else {
                                videoView.stopPlayback();
                                imageView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        });
    }


    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}