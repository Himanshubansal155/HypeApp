package com.example.rc.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Fourth extends AppCompatActivity {
    Button b1,b2,b3;
    ImageView i1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bm=(Bitmap)data.getExtras().get("data");
        i1.setImageBitmap(bm);
        if(bm==null) {
            startActivity(new Intent(Fourth.this, Fourth.class));
            finish();
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b1=(Button)findViewById(R.id.button12);
        b2=(Button)findViewById(R.id.button13);
        b3=(Button)findViewById(R.id.button16);
        i1=(ImageView)findViewById(R.id.imageView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Fourth.this,Tenth.class);
                startActivity(j);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Fourth.this,Third.class);
                startActivity(k);
                finish();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        menu.findItem(R.id.camera).setVisible(false);
        menu.findItem(R.id.sms).setVisible(false);
        menu.findItem(R.id.youtube).setVisible(false);
        menu.findItem(R.id.musicplayer).setVisible(false);
        menu.findItem(R.id.calculator).setVisible(false);
        menu.findItem(R.id.videoplayer).setVisible(false);
        menu.findItem(R.id.quiz).setVisible(false);
        menu.findItem(R.id.phonecall).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.mainmenu:
                startActivity(new Intent(Fourth.this,Third.class));
                finish();
                break;

            case R.id.logout:
                startActivity(new Intent(Fourth.this,MainActivity.class));
                finish();
                break;



        }
        return true;
    }
}
