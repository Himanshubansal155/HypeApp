package com.example.rc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Eleven extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);
        b1=(Button)findViewById(R.id.button37);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                if (r4.isChecked())
                {
                    ++score;
                }
                else
                {
                    --score;
                }
                Intent i=new Intent(Eleven.this,Eleven2.class);
                startActivity(i);
                finish();
            }
        });

    }
}
