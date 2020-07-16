package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Eleven2 extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;
    static int score1=0;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven2);
        b1=(Button)findViewById(R.id.button40);
        t1=(TextView)findViewById(R.id.textView36);
        r1=(RadioButton)findViewById(R.id.radioButton5);
        r2=(RadioButton)findViewById(R.id.radioButton6);
        r3=(RadioButton)findViewById(R.id.radioButton7);
        r4=(RadioButton)findViewById(R.id.radioButton8);
        t1.setText("Your Score is "+Eleven.score+"/5");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1=Eleven.score;
                if (r3.isChecked())
                {
                    ++score1;
                }
                else
                {
                    --score1;
                }
                Eleven.score=score1;

                Intent i=new Intent(Eleven2.this,Eleven3.class);
                startActivity(i);
                finish();
            }
        });

    }
}
