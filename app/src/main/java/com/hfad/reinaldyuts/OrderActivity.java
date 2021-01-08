package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    public static final String EXTRA_ORDER = "abc";
    ArrayList<Drinks> arrOrder = new ArrayList<>();
    Drinks data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
         data = (Drinks) bundle.getSerializable(DrinksActivity.EXTRA_MESSAGE);

        arrOrder = (ArrayList<Drinks>) bundle.getSerializable(DrinksActivity.EXTRA_ORDER);



        TextView textnama = findViewById(R.id.namaproductTxt);
        textnama.setText(data.getName());

        TextView textPrice = findViewById(R.id.rupiah);
        textPrice.setText(Integer.toString(data.getPrice()));




    }



    public void orderMore(View view) {

        EditText qtyText = findViewById(R.id.QuantityTxt);
        if(qtyText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }

        int qty = Integer.parseInt(qtyText.getText().toString());
        if(qty<=0){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }
//            data.setQty(Integer.parseInt(qtyText.getText().toString()));
        data.setQty(qty);


                arrOrder.add(data);

                Bundle bundle1 = new Bundle();
                Intent intent1 = new Intent(this,DrinksActivity.class);
                bundle1.putSerializable(EXTRA_ORDER, arrOrder);
                intent1.putExtras(bundle1);
                startActivity(intent1);


    }

    public void myOrder(View view) {
        EditText qtyText = findViewById(R.id.QuantityTxt);
        if(qtyText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }

        int qty = Integer.parseInt(qtyText.getText().toString());
        if(qty<=0){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }
//            data.setQty(Integer.parseInt(qtyText.getText().toString()));
        data.setQty(qty);


        arrOrder.add(data);

        Bundle bundle1 = new Bundle();
        Intent intent1 = new Intent(this,MyOrderActivity.class);
        bundle1.putSerializable(EXTRA_ORDER, arrOrder);
        intent1.putExtras(bundle1);
        startActivity(intent1);
    }
}