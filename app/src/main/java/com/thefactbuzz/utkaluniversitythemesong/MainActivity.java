package com.thefactbuzz.utkaluniversitythemesong;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    int pauseposition;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button play = (Button) findViewById(R.id.playButton);

        Button pause = (Button) findViewById(R.id.pauseButton);

        Button stop = (Button) findViewById(R.id.stopButton);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.playButton:

                if (mediaPlayer==null)
                {
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
                mediaPlayer.start();
                }
                else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseposition);
                    mediaPlayer.start();
                }

            break;
            case R.id.pauseButton:
                if (mediaPlayer!=null){
                    mediaPlayer.pause();
                    pauseposition = mediaPlayer.getCurrentPosition();

                }
                break;
            case R.id.stopButton:
                if (mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;

        }


    }
}
