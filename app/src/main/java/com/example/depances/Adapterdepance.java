package com.example.depances;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class Adapterdepance extends ArrayAdapter {
    private ArrayList<Depance> arrayList;
    private Context ctx;
    private int item;
    public Adapterdepance(@NonNull Context context, int resource , ArrayList<Depance> myarray) {
        super(context, resource,myarray);
        this.arrayList=myarray;
        this.ctx=context;
        this.item=resource; }
    @NonNull
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(ctx).inflate(item,parent,false);
        TextView montant=convertView.findViewById(R.id.t1);
        TextView  date=convertView.findViewById(R.id.t2);
        TextView  achat=convertView.findViewById(R.id.ac);
        achat.setText(arrayList.get(position).getAchat());
        montant.setText(arrayList.get(position).getMontant()+" DT");
        date.setText("le "+arrayList.get(position).getJour()+" / "+arrayList.get(position).getMois()+" / "+ arrayList.get(position).getAnnée());
        return convertView; }}