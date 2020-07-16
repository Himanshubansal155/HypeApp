package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Eleven5 extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    static int score4=0;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven5);
        b1=(Button)findViewById(R.id.button50);
        t1=(TextView)findViewById(R.id.textView39);
        r1=(RadioButton)findViewById(R.id.radioButton17);
        r2=(RadioButton)findViewById(R.id.radioButton18);
        r3=(RadioButton)findViewById(R.id.radioButton19);
        r4=(RadioButton)findViewById(R.id.radioButton20);
        t1.setText("Your Score is "+Eleven.score+"/5");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score4=Eleven.score;
                if (r3.isChecked())
                {
                    ++score4;
                }
                else
                {
                    --score4;
                }
                Eleven.score=score4;

                Intent i=new Intent(Eleven5.this,Eleven6.class);
                startActivity(i);
                finish();
            }
        });

    }
}
