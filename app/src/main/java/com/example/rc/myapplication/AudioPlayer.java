package com.example.rc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class AudioPlayer extends AppCompatActivity implements View.OnClickListener {
    private Button btnPlay,btnBack,btnFor,b1;
    private SeekBar seekbar;
    private MediaPlayer mediaplayer;
    private Runnable runnable;
    private Handler handler;
    Uri uri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        b1=(Button)findViewById(R.id.button54);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(AudioPlayer.this,MusicP.class);
                startActivity(i1);
                finish();
                mediaplayer.stop();

            }
        });
        if(mediaplayer!=null){
            mediaplayer.stop();
            mediaplayer.release();
        }
        dostuff();

    }
    public void dostuff(){
        btnPlay=(Button)findViewById(R.id.button51);
        btnFor=(Button)findViewById(R.id.button53);
        btnBack=(Button)findViewById(R.id.button52);
        handler=new Handler();
        seekbar=(SeekBar)findViewById(R.id.seekBar);
        Bundle bundle=getIntent().getExtras();
        ArrayList<File> songs=(ArrayList) bundle.getParcelableArrayList("list");
        int position=bundle.getInt("position");
        uri = Uri.parse(songs.get(position).toString());
        mediaplayer=MediaPlayer.create(this,uri);
        btnFor.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnPlay.setOnClickListener(this);





        mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekbar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaplayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    private void changeSeekbar(){
        seekbar.setProgress(mediaplayer.getCurrentPosition());
        if(mediaplayer.isPlaying()){
            runnable=new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button51:
                if(mediaplayer.isPlaying()){
                    mediaplayer.pause();
                    btnPlay.setText("|>");
                }
                else{
                    mediaplayer.start();
                    btnPlay.setText("||");
                    changeSeekbar();
                }
                break;
            case R.id.button53:
                mediaplayer.seekTo(mediaplayer.getCurrentPosition()+5000);
                break;
            case R.id.button52:
                mediaplayer.seekTo(mediaplayer.getCurrentPosition()-5000);
                break;
        }

    }
}
