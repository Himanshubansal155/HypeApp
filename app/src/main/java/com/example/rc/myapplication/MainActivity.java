package com.example.rc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    public static String s1;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.4f);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "fill all", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("gla",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student (name varchar,email varchar,phone varchar,city varchar,password varchar)");
                    String s4="select * from student where name='"+s1+"'and password='"+s2+"'";
                    Cursor c=data.rawQuery(s4,null);
                    if(c.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(MainActivity.this,Third.class);
                        startActivity(j);
                        finish();
                        t1.speak("    Welcome "+MainActivity.s1,TextToSpeech.QUEUE_FLUSH,null);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Mismatch data", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}
