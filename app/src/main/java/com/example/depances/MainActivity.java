package com.example.depances;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
//create by amrou hajji
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView li1;
    ArrayList<Depance> myliste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li1 = findViewById(R.id.l);
        myliste = new ArrayList<>();
       final DBadapter dBadapter=new DBadapter(this);
        li1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ArrayList<Depance> myliste2;
                                myliste2 = new ArrayList<>();
                                for (int i=0;i<myliste.size();i++)
                                    if (i!=position)
                                    {myliste2.add(myliste.get(i));}
                                myliste=myliste2;
                                dBadapter.remove();
                                final DBadapter dBadapter=new DBadapter(MainActivity.this);
                                for (int i=0;i<myliste.size();i++){
                                    dBadapter.ajoutdepance(myliste.get(i)); }
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "supprimé", Toast.LENGTH_SHORT).show(); }})
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show(); }});
        myliste=dBadapter.afficher();
        Adapterdepance array = new Adapterdepance(this, R.layout.depance_item, myliste);
        li1.setAdapter(array);}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.add_depance, menu);
        return  true; }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.addd2) {
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent); }
        if(item.getItemId()==R.id.addd) {
            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent); }return  true; }}