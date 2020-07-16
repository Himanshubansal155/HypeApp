package com.example.rc.myapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Seventh extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, cancel, equal,b1;
    EditText disp;
    int op1;
    int op2;
    String optr;
    TextToSpeech tx1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        b1=(Button)findViewById(R.id.button32);
        tx1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                tx1.setLanguage(Locale.ENGLISH);
                tx1.setSpeechRate(0.4f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Seventh.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        one = (Button) findViewById(R.id.button15);
        two = (Button) findViewById(R.id.button17);
        three = (Button) findViewById(R.id.button18);
        four = (Button) findViewById(R.id.button20);
        five = (Button) findViewById(R.id.button21);
        six = (Button) findViewById(R.id.button22);
        seven = (Button) findViewById(R.id.button23);
        eight = (Button) findViewById(R.id.button24);
        nine = (Button) findViewById(R.id.button25);
        zero = (Button) findViewById(R.id.button27);
        add = (Button) findViewById(R.id.button29);
        sub = (Button) findViewById(R.id.button30);
        mul = (Button) findViewById(R.id.button31);
        div = (Button) findViewById(R.id.button28);
        cancel = (Button) findViewById(R.id.button26);
        equal = (Button) findViewById(R.id.button19);
        disp = (EditText) findViewById(R.id.display);


        try {
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);
            cancel.setOnClickListener(this);
            add.setOnClickListener(this);
            sub.setOnClickListener(this);
            mul.setOnClickListener(this);
            div.setOnClickListener(this);
            equal.setOnClickListener(this);
        } catch (Exception e) {

        }
    }

    public void operation() {
        if (optr.equals("+")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 + op2;
            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
            disp.setText(Integer.toString(op1));
        } else if (optr.equals("-")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 - op2;
            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
            disp.setText( Integer.toString(op1));
        } else if (optr.equals("*")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 * op2;
            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
            disp.setText(Integer.toString(op1));
        } else if (optr.equals("/")) {
            op2 = Integer.parseInt(disp.getText().toString());
            disp.setText("");
            op1 = op1 / op2;
            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
            disp.setText( Integer.toString(op1));
        }
    }

    @Override
    public void onClick(View arg0) {

        Editable str = disp.getText();
        switch (arg0.getId()) {

            case R.id.button15:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(one.getText());
                disp.setText(str);
                break;
            case R.id.button17:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(two.getText());
                disp.setText(str);
                break;
            case R.id.button18:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(three.getText());
                disp.setText(str);
                break;
            case R.id.button20:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(four.getText());
                disp.setText(str);
                break;
            case R.id.button21:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(five.getText());
                disp.setText(str);
                break;
            case R.id.button22:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(six.getText());
                disp.setText(str);
                break;
            case R.id.button23:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(seven.getText());
                disp.setText(str);
                break;
            case R.id.button24:
                if (op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(eight.getText());
                disp.setText(str);
                break;
            case R.id.button25:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(nine.getText());
                disp.setText(str);
                break;
            case R.id.button27:
                if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(zero.getText());
                disp.setText(str);
                break;
            case R.id.button26:
                op1 = 0;
                op2 = 0;
                disp.setText("");
                disp.setHint("Perform Operation :)");
                break;
            case R.id.button29:
                optr = "+";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 + op2;
                    tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                    disp.setText(Integer.toString(op1));
                }
                break;
            case R.id.button30:
                optr = "-";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 - op2;
                    tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                    disp.setText( Integer.toString(op1));
                }
                break;
            case R.id.button31:
                optr = "*";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 * op2;
                    tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                    disp.setText( Integer.toString(op1));
                }
                break;
            case R.id.button28:
                optr = "/";
                if (op1 == 0) {
                    op1 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    disp.setText("");
                } else {
                    op2 = Integer.parseInt(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 / op2;
                    tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                    disp.setText(Integer.toString(op1));
                }
                break;
            case R.id.button19:
                if (!optr.equals(null)) {
                    if (op2 != 0) {
                        if (optr.equals("+")) {
                            disp.setText(""); /*op1 = op1 + op2;*/
                            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                            disp.setText( Integer.toString(op1));
                        } else if (optr.equals("-")) {
                            disp.setText("");/* op1 = op1 - op2;*/
                            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                            disp.setText( Integer.toString(op1));
                        } else if (optr.equals("*")) {
                            disp.setText("");/* op1 = op1 * op2;*/
                            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                            disp.setText( Integer.toString(op1));
                        } else if (optr.equals("/")) {
                            disp.setText("");/* op1 = op1 / op2;*/
                            tx1.speak("Result is"+op1,TextToSpeech.QUEUE_FLUSH,null);
                            disp.setText( Integer.toString(op1));
                        }
                    } else {
                        operation();
                    }
                }
                break;
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
                startActivity(new Intent(Seventh.this,Third.class));
                finish();
                break;

            case R.id.logout:
                startActivity(new Intent(Seventh.this,MainActivity.class));
                finish();
                break;



        }
        return true;
    }
}
