package com.example.depances;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class DBadapter extends SQLiteOpenHelper {
    public DBadapter (Context context){
        super(context,"formalab",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatTable="create table depance(id integer primary key,jour text,mois text,année text,montant text,achat text)";
        db.execSQL(creatTable); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable=("drop table if exists depance ");
        db.execSQL(deleteTable);
        onCreate(db); }
    public void remove(){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("depance","",null);}
    public void ajoutdepance(Depance contact){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("jour",contact.getJour());
        contentValues.put("mois",contact.getMois());
        contentValues.put("année",contact.getAnnée());
        contentValues.put("montant",contact.getMontant());
        contentValues.put("achat",contact.getAchat());
        db.insert("depance",null,contentValues); }
        public int totale(){
        int s=0;
            SQLiteDatabase db=getReadableDatabase();
            String selectall="SELECT * FROM depance";
            Cursor cursor= db.rawQuery(selectall,null);
            if (cursor.moveToFirst()){ do{
                    s=s+Integer.valueOf((cursor.getString(4))); }
                while(cursor.moveToNext()); }
        return s;}
        public String min(){
        String s1="0";
            String s2="0";
            String s3="0";
            SQLiteDatabase db=getReadableDatabase();
            String selectall="SELECT * FROM depance";
            Cursor cursor1= db.rawQuery(selectall,null);
            Cursor cursor2= db.rawQuery(selectall,null);
            Cursor cursor3= db.rawQuery(selectall,null);
            if (cursor1.moveToFirst()){
                s1=cursor1.getString(3);
                do{
                    if (Integer.valueOf(s1)>Integer.valueOf(cursor1.getString(3)))
                    s1=cursor1.getString(3); }
                while(cursor1.moveToNext()); }
            if (cursor2.moveToFirst()){
                s2="13";
                do{if(Integer.valueOf(cursor2.getString(3)).equals(Integer.valueOf(s1))){
                    if (Integer.valueOf(s2)>Integer.valueOf(cursor2.getString(2)))
                        s2=cursor2.getString(2); }}
                while(cursor2.moveToNext()); }
            if (cursor3.moveToFirst()){
                s3="32";
                do{if(Integer.valueOf(cursor3.getString(3)).equals(Integer.valueOf(s1)) && Integer.valueOf(cursor3.getString(2)).equals(Integer.valueOf(s2)))
                {if (Integer.valueOf(s3)>Integer.valueOf(cursor3.getString(1)))
                {s3=cursor3.getString(1); }}}
                while(cursor3.moveToNext()); }
                String s=s3+"/"+s2+"/"+s1;
        return s;}
    public ArrayList<Depance> afficher(){
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM depance";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<Depance> depances=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                Depance depance=new Depance(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
                depances.add(depance); }
            while(cursor.moveToNext()); }
        return depances;}}
