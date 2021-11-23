package com.example.ezyfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ezyfoodapp.Adapter.ItemAdapter;
import com.example.ezyfoodapp.Model.Drinks;
import com.example.ezyfoodapp.Model.Foods;
import com.example.ezyfoodapp.Model.Item;
import com.example.ezyfoodapp.Model.Snacks;

import java.util.ArrayList;
import java.util.List;

public class createOrder extends AppCompatActivity {
    private RecyclerView itemRecyclerView;
    private ItemAdapter itemAdapter;
    private String type;
    private List<Item> itemList;
    private List<Item> realData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        itemList = new ArrayList<>();
        realData = new ArrayList<>();

        itemRecyclerView=(RecyclerView)findViewById(R.id.itemRecyclerView);
        itemRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        itemAdapter = new ItemAdapter(this);
        itemRecyclerView.setAdapter(itemAdapter);

            //The key argument here must match that used in the other activity


        Item item = new Drinks();
        item.setItemName("Air Mineral");
        item.setPrice(123);
        item.setId(1);
        item.setItemType("drinks");
        itemList.add(item);
//        food
        Item item1 = new Foods();
        item1.setItemName("Ayam Bakar");
        item1.setPrice(123);
        item1.setId(1);
        item1.setItemType("foods");
        itemList.add(item1);
        //snack
        Item item2 = new Snacks();
        item2.setItemName("Chitato");
        item2.setPrice(123);
        item2.setId(1);
        item2.setItemType("snacks");
        itemList.add(item2);

        //      //get passed data
        Bundle extras = getIntent().getExtras();

        type = extras.getString("type");

        for(int i=0; i<itemList.size();i++){
            if(itemList.get(i).getItemType().equals(type)) {

                realData.add(itemList.get(i));
            }
        }

        itemAdapter.setItem(realData);

        Button btn = (Button) findViewById(R.id.btnMyOrder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(createOrder.this,MyOrder.class);
                startActivity(open);
            }
        });

    }
}