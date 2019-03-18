package com.example.depances;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
TextView s1,s2;
Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int s;
        String ch;
        DBadapter dBadapter=new DBadapter(this);
        s=dBadapter.totale();
        setContentView(R.layout.activity_main3);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        r=findViewById(R.id.r);
        s2.setText(String.valueOf(s)+" DT");
        if (dBadapter.min().equals("0/0/0")) {ch="aucune depance enrigistrer";
            }else {ch=dBadapter.min();}
        s1.setText(ch);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { {
                    DBadapter dBadapter=new DBadapter(Main3Activity.this);
                    dBadapter.remove();
                    Intent intent=new Intent(Main3Activity.this,MainActivity.class);
                    startActivity(intent); }}});}}
