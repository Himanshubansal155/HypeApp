package com.example.rc.myapplication;

import android.Manifest;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Phone extends AppCompatActivity {
    EditText edittext1;
    Button button1,b2,b1;
    private static final int RESULT_PICK_CONTACT=1;
    private static final int MY_PERMISSION_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        if(ContextCompat.checkSelfPermission(Phone.this,
                Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(Phone.this, Manifest.permission.CALL_PHONE)){
                ActivityCompat.requestPermissions(Phone.this,
                        new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSION_REQUEST);
            }else{
                ActivityCompat.requestPermissions(Phone.this,
                        new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSION_REQUEST);
            }
        }
        else{
            dostuff();
        }


    }
    public void dostuff(){
        edittext1=(EditText)findViewById(R.id.editText11);
        button1=(Button)findViewById(R.id.button43);
        b1=(Button)findViewById(R.id.button48);
        b2=(Button)findViewById(R.id.button46);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=edittext1.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
                edittext1.setText("");

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(i, RESULT_PICK_CONTACT);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Phone.this,Third.class);
                startActivity(k);
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;
            }
        } else {
            Toast.makeText(Phone.this, "Failed to pick contacts", Toast.LENGTH_SHORT).show();
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
            edittext1.setText(phone);
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
                    if(ContextCompat.checkSelfPermission(Phone.this, Manifest.permission.CALL_PHONE)
                            ==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(Phone.this, "", Toast.LENGTH_SHORT).show();
                        dostuff();
                    }
                }else{
                    Toast.makeText(Phone.this, "no", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(Phone.this,Third.class));
                finish();
                break;

            case R.id.logout:
                startActivity(new Intent(Phone.this,MainActivity.class));
                finish();
                break;



        }
        return true;
    }
}
