package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderComplete extends AppCompatActivity {
    ArrayList<Drinks> arrOrder = new ArrayList<>();
    GridView gridView;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; //object
    public static final String EXTRA_ORDER = "abc"; //array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        arrOrder = (ArrayList<Drinks>) bundle.getSerializable(DrinksActivity.EXTRA_ORDER);

       AdapterOrderComplete drinkadapter = new AdapterOrderComplete(OrderComplete.this,arrOrder);

        TextView totalPrice = findViewById(R.id.totalTxt);
        totalPrice.setText("Total Price : Rp. "+getTotalPrice());

        gridView = findViewById(R.id.gridOrder);
        gridView.setAdapter(drinkadapter);

    }
    private int getTotalPrice(){
        int totalPrice = 0;
        for(Drinks drinks : arrOrder){
            totalPrice += (drinks.getQty() * drinks.getPrice());
        }
        return totalPrice;
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}