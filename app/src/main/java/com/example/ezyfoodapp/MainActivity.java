package com.example.ezyfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezyfoodapp.Model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drink
        CardView drink = findViewById(R.id.drinks);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(MainActivity.this,createOrder.class);
                open.putExtra("type","drinks");
                startActivity(open);
            }
        });
        //food
        CardView food = findViewById(R.id.foods);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(MainActivity.this,createOrder.class);
                open.putExtra("type","foods");
                startActivity(open);
            }
        });
        //snack
        CardView snack = findViewById(R.id.snacks);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(MainActivity.this,createOrder.class);
                open.putExtra("type","snacks");
                startActivity(open);
            }
        });
        //topup
        CardView topup = findViewById(R.id.topUp);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(MainActivity.this,createOrder.class);
                open.putExtra("type","topup");
                startActivity(open);
            }
        });

        Button btn = (Button) findViewById(R.id.btnMyOrder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(MainActivity.this,MyOrder.class);
                startActivity(open);
            }
        });
    }

}