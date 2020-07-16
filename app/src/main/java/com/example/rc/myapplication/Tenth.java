package com.example.rc.myapplication;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Tenth extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(Tenth.this, "Video has been saved to:\\n"+data.getData(), Toast.LENGTH_LONG).show();
        Intent j=new Intent(Tenth.this,Fourth.class);
        startActivity(j);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(i,0);
        
        
        
        
    }
}
