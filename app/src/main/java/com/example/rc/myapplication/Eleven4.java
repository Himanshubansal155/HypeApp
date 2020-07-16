package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Eleven4 extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    static int score3=0;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven4);
        b1=(Button)findViewById(R.id.button47);
        t1=(TextView)findViewById(R.id.textView38);
        r1=(RadioButton)findViewById(R.id.radioButton13);
        r2=(RadioButton)findViewById(R.id.radioButton14);
        r3=(RadioButton)findViewById(R.id.radioButton15);
        r4=(RadioButton)findViewById(R.id.radioButton16);
        t1.setText("Your Score is "+Eleven.score+"/5");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score3=Eleven.score;
                if (r2.isChecked())
                {
                    ++score3;
                }
                else
                {
                    --score3;
                }
                Eleven.score=score3;

                Intent i=new Intent(Eleven4.this,Eleven5.class);
                startActivity(i);
                finish();
            }
        });

    }
}
