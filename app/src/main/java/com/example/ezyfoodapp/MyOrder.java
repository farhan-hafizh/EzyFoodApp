package com.example.ezyfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfoodapp.Adapter.OrderAdapter;
import com.example.ezyfoodapp.Model.Orders;

import java.util.ArrayList;
import java.util.List;

public class MyOrder extends AppCompatActivity {
    private List<Orders> ordersList;
    private RecyclerView orderRecyclerView;
    private  OrderAdapter orderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        ordersList= new ArrayList<>();
        orderRecyclerView=findViewById(R.id.ordersRecyclerView);
        orderRecyclerView.setLayoutManager(new GridLayoutManager(null,2));
        orderAdapter = new OrderAdapter(this);
        orderRecyclerView.setAdapter(orderAdapter);


        Orders order =new Orders();
        order.setId(1);
        order.setItemName("Air Mineral");
        order.setItemType("drinks");
        order.setPrice(123);
        order.setQuantity(5);
        order.setTotalPrice(order.getPrice()*order.getQuantity());
        ordersList.add(order);

        Orders order1 =new Orders();
        order1.setId(2);
        order1.setItemName("Jus Mangga");
        order1.setItemType("drinks");
        order1.setPrice(123);
        order1.setQuantity(2);
        order1.setTotalPrice(order1.getPrice()*order1.getQuantity());
        ordersList.add(order1);

        Orders order2 =new Orders();
        order2.setId(3);
        order2.setItemName("Jus Apel");
        order2.setItemType("drinks");
        order2.setPrice(123);
        order2.setQuantity(2);
        order2.setTotalPrice(order2.getPrice()*order2.getQuantity());
        ordersList.add(order2);

        orderAdapter.setOrders(ordersList);
        int Total=0;
        for (int i = 0 ; i<ordersList.size();i++ ){
            Total+=ordersList.get(i).getTotalPrice();
        }

        TextView total = findViewById(R.id.total);
        total.setText("Total Price: Rp." +String.valueOf(Total));

        Button btn = (Button) findViewById(R.id.btnPay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PaidAlert().show(getSupportFragmentManager(), "Dialog");
            }
        });


    }
}