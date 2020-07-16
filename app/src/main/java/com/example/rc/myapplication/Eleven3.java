package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Eleven3 extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    static int score2=0;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven3);
        b1=(Button)findViewById(R.id.button44);
        t1=(TextView)findViewById(R.id.textView37);
        r1=(RadioButton)findViewById(R.id.radioButton9);
        r2=(RadioButton)findViewById(R.id.radioButton10);
        r3=(RadioButton)findViewById(R.id.radioButton11);
        r4=(RadioButton)findViewById(R.id.radioButton12);
        t1.setText("Your Score is "+Eleven.score+"/5");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2=Eleven.score;
                if (r3.isChecked())
                {
                    ++score2;
                }
                else
                {
                    --score2;
                }
                Eleven.score=score2;

                Intent i=new Intent(Eleven3.this,Eleven4.class);
                startActivity(i);
                finish();
            }
        });
    }
}
