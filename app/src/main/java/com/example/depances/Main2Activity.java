package com.example.depances;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Main2Activity extends AppCompatActivity {
    EditText e1,e2,e3,e4,a;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String montant=e1.getText().toString() ;
                String jour=e2.getText().toString() ;
                String mois=e3.getText().toString() ;
                String année=e4.getText().toString() ;
                String achat=a.getText().toString();
                if (!(année.isEmpty())){
                    if (!(montant.isEmpty())){
                        if (!(achat.isEmpty())){
                            if (!(jour.isEmpty())){
                                if (!(mois.isEmpty())) {
                                    if (Integer.valueOf(jour)!=0){
                                        if (((mois.matches("1") && Integer.valueOf(jour)<32) ||
                                                (mois.matches("2") && Integer.valueOf(jour)<30) ||
                                                (mois.matches("3") && Integer.valueOf(jour)<32) ||
                                                (mois.matches("4") && Integer.valueOf(jour)<31) ||
                                                (mois.matches("5") && Integer.valueOf(jour)<32) ||
                                                (mois.matches("6") && Integer.valueOf(jour)<31) ||
                                                (mois.matches("7") && Integer.valueOf(jour)<32) ||
                                                (mois.matches("8") && Integer.valueOf(jour)<32) ||
                                                (mois.matches("9") && Integer.valueOf(jour)<31) ||
                                                (mois.matches("10") && Integer.valueOf(jour)<32) ||
                                                (mois.matches("11") && Integer.valueOf(jour)<31) ||
                                                (mois.matches("12") && Integer.valueOf(jour)<32)))
                {Depance depance=new Depance(jour,mois,année,montant,achat);
                    DBadapter dBadapter=new DBadapter(Main2Activity.this);
                    dBadapter.ajoutdepance(depance);
                    Toast.makeText(Main2Activity.this, "ajouter", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(intent);}
                    else{Toast.makeText(Main2Activity.this, "jour ou mois incorrect", Toast.LENGTH_SHORT).show();}}
                    else{Toast.makeText(Main2Activity.this, "nombre de jour nul", Toast.LENGTH_SHORT).show();}}
                    else {Toast.makeText(Main2Activity.this, "case de mois vide", Toast.LENGTH_SHORT).show();}}
                    else {Toast.makeText(Main2Activity.this, "case de jour vide", Toast.LENGTH_SHORT).show();}}
                    else {Toast.makeText(Main2Activity.this, "case d'achat vide", Toast.LENGTH_SHORT).show();}}
                    else {Toast.makeText(Main2Activity.this, "case de prix vide", Toast.LENGTH_SHORT).show();}}
                    else {Toast.makeText(Main2Activity.this, "case de année vide", Toast.LENGTH_SHORT).show();} }});}}