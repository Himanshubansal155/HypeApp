package com.example.rc.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MusicP extends AppCompatActivity {
    private ListView listView;
    private String songNames[];
    private static final int MY_PERMISSION_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_p);
        if(ContextCompat.checkSelfPermission(MusicP.this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MusicP.this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MusicP.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }else{
                ActivityCompat.requestPermissions(MusicP.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
        }
        else{
            dostuff();
        }
    }

    public void dostuff(){

        listView= (ListView) findViewById(R.id.listView);
        final ArrayList<File> songs=readSongs(Environment.getExternalStorageDirectory());
        songNames=new String[songs.size()];
        for (int i=0;i<songs.size();++i){
            songNames[i]=songs.get(i).getName().replace(".mp3","");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView40,songNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MusicP.this, AudioPlayer.class).putExtra("position",i).putExtra("list",songs));

            }
        });


    }

    private ArrayList<File>readSongs(File root){
        ArrayList<File>arrayList=new ArrayList<File>();
        File files[]=root.listFiles();

        for(File file:files){
            if(file.isDirectory()){
                arrayList.addAll(readSongs(file));
            }
            else{
                if(file.getName().endsWith(".mp3")){
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSION_REQUEST:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MusicP.this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
                            ==PackageManager.PERMISSION_GRANTED){
                        dostuff();
                    }
                }else{
                    Toast.makeText(MusicP.this, "no", Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        menu.findItem(R.id.camera).setVisible(false);
        menu.findItem(R.id.sms).setVisible(false);
        menu.findItem(R.id.youtube).setVisible(false);
        menu.findItem(R.id.musicplayer).setVisible(false);
        menu.findItem(R.id.phonecall).setVisible(false);
        menu.findItem(R.id.calculator).setVisible(false);
        menu.findItem(R.id.videoplayer).setVisible(false);
        menu.findItem(R.id.quiz).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.mainmenu:
                startActivity(new Intent(MusicP.this,Third.class));
                finish();
                break;

            case R.id.logout:
                startActivity(new Intent(MusicP.this,MainActivity.class));
                finish();
                break;



        }
        return true;
    }

}
