package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 //private Intent move = new Intent();

    ArrayList<Drinks> arrOrder = new ArrayList<>();
    public static final String EXTRA_ORDER = "abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Drinks(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,DrinksActivity.class);
        bundle.putSerializable(EXTRA_ORDER, arrOrder);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void Snacks(View view) {
    }

    public void Foods(View view) {
    }

    public void Topup(View view) {
    }

    public void myOrder(View view) {
        Toast.makeText(getApplicationContext(),"Data masih kosong",Toast.LENGTH_SHORT).show();
    }

    public void Store(View view) {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
        finish();
    }
}