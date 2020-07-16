package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Third extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ViewPager viewPager
                = (ViewPager)findViewById(
                R.id.viewpager);

        SimpleFragmentPageAdapter
                adapter
                = new SimpleFragmentPageAdapter(
                getSupportFragmentManager());

        viewPager.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        menu.findItem(R.id.mainmenu).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.youtube:
                startActivity(new Intent(Third.this,Youtube.class));
                finish();
                break;
            case R.id.camera:
                startActivity(new Intent(Third.this,Fourth.class));
                finish();
                break;
            case R.id.calculator:
                startActivity(new Intent(Third.this,Seventh.class));
                finish();
                break;
            case R.id.quiz:
                startActivity(new Intent(Third.this,Ninth.class));
                finish();
                break;
            case R.id.sms:
                startActivity(new Intent(Third.this,Sixth.class));
                finish();
                break;

            case R.id.logout:
                startActivity(new Intent(Third.this,MainActivity.class));
                finish();
                break;
            case R.id.videoplayer:
                startActivity(new Intent(Third.this,Eight.class));
                finish();
                break;

            case R.id.musicplayer:
                startActivity(new Intent(Third.this,MusicP.class));
                finish();
                break;
            case R.id.phonecall:
                startActivity(new Intent(Third.this,Phone.class));
                finish();
                break;

        }
        return true;
    }
}
