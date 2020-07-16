package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Eleven6 extends AppCompatActivity {
    TextView t1,t2;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven6);
        t1=(TextView)findViewById(R.id.textView18);
        t2=(TextView)findViewById(R.id.textView8);
        t1.setText("     Your score is "+Eleven.score);
        t2.setText("Thank You For Participation \n"+MainActivity.s1);
        b1=(Button)findViewById(R.id.button36);
        b2=(Button)findViewById(R.id.button35);
        b3=(Button)findViewById(R.id.button38);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Eleven6.this,Eleven7.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Eleven6.this,Third.class);
                startActivity(j);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "Score of the Indian Cultural Quiz played by me in the Hype app is "+Eleven.score+"out of 5 question";
                String sub = "Quiz score";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });
    }

}
