package com.example.rc.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class Sixth extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b3, b2;
    private static final int RESULT_PICK_CONTACT=1;
    private static final int MY_PERMISSION_REQUEST=1;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        if(ContextCompat.checkSelfPermission(Sixth.this,
                Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(Sixth.this,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(Sixth.this,
                        new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST);
            }else{
                ActivityCompat.requestPermissions(Sixth.this,
                        new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST);
            }
        }
        else{
            dostuff();
        }



    }
    public void dostuff(){
        e1 = (EditText) findViewById(R.id.editText8);
        e2 = (EditText) findViewById(R.id.editText9);
        b1 = (Button) findViewById(R.id.button14);
        b2 = (Button) findViewById(R.id.button45);
        b3 = (Button) findViewById(R.id.button20);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.equals(""))
                {
                    Toast.makeText(Sixth.this, "Enter Valid Phone number", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Sixth.class);
                    PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(s1, null, s2, pi, null);
                    Toast.makeText(Sixth.this, "Message Send Successfully", LENGTH_LONG).show();
                    startActivity(new Intent(Sixth.this,Sixth.class));
                    finish();}
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(Sixth.this, Third.class);
                startActivity(k);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(i, RESULT_PICK_CONTACT);
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            switch(requestCode){
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;}
        }
        else{
            Toast.makeText(Sixth.this, "Failed to pick contacts", Toast.LENGTH_SHORT).show();
        }

    }
    private void contactPicked(Intent data) {
        Cursor cursor = null;
        try {
            String phone=null;
            Uri uri=data.getData();
            cursor=getContentResolver().query(uri,null,null,null,null);
            cursor.moveToFirst();
            int phoneIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phone=cursor.getString(phoneIndex);
            e1.setText(phone);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSION_REQUEST:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(Sixth.this, Manifest.permission.SEND_SMS)
                            ==PackageManager.PERMISSION_GRANTED){
                        dostuff();
                    }
                }else{
                    Toast.makeText(Sixth.this, "No", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(Sixth.this,Third.class));
                finish();
                break;

            case R.id.logout:
                startActivity(new Intent(Sixth.this,MainActivity.class));
                finish();
                break;



        }
        return true;
    }
}
