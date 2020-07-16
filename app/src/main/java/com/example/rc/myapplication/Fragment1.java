package com.example.rc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment {
    Button b1,b2,b3;
    TextView t1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fragment1, container, false);
        b1 = (Button) v.findViewById(R.id.button5);
        b2 = (Button) v.findViewById(R.id.button7);
        b3 = (Button) v.findViewById(R.id.button9);
        t1=(TextView) v.findViewById(R.id.textView4);
        t1.setText("Welcome "+MainActivity.s1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),Fourth.class);
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(getActivity(),Sixth.class);
                startActivity(j);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(getActivity(),MainActivity.class);
                startActivity(k);
            }
        });
        return v;
    }


}
