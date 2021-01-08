package com.hfad.reinaldyuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {
     ArrayList<Drinks> arrDrinks = new ArrayList<>();
    ArrayList<Drinks> arrOrder = new ArrayList<>();
    GridView gridView ;
    public void isiDrink(){

        arrDrinks.add(new Drinks("Guli-Guli",50000,R.drawable.bubble));
        arrDrinks.add(new Drinks("Mana-Mini",30000,R.drawable.kopi));
        arrDrinks.add(new Drinks("Kawai-Kawai",10000,R.drawable.tea));
        arrDrinks.add(new Drinks("Itam-Manis",5000,R.drawable.kopiitem));

    }


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; //object
    public static final String EXTRA_ORDER = "abc"; //array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        isiDrink();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        arrOrder = (ArrayList<Drinks>) bundle.getSerializable(MainActivity.EXTRA_ORDER);



        AdapterDrink drinkadapter = new AdapterDrink(DrinksActivity.this,arrDrinks);

        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(drinkadapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You Choosed Item",Toast.LENGTH_SHORT).show();
                Drinks objDrinks = arrDrinks.get(i);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getBaseContext(),OrderActivity.class);
                bundle.putSerializable(EXTRA_ORDER, arrOrder);
                bundle.putSerializable(EXTRA_MESSAGE,objDrinks);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


}
    public void myOrder(View view) {
        //Toast.makeText(getApplicationContext(),"abc" + arrOrder.size(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyOrderActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable(EXTRA_ORDER,arrOrder);
        intent.putExtras(bundle);


        startActivity(intent);
    }
}
