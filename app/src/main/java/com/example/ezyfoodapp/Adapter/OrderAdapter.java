package com.example.ezyfoodapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfoodapp.Model.Orders;
import com.example.ezyfoodapp.MyOrder;
import com.example.ezyfoodapp.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<Orders> orderList;
    private MyOrder activity;

    //constructor
    public OrderAdapter(MyOrder activity){
        this.activity=activity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_card_layout,parent, false);

        return new OrderAdapter.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position){
        Orders item = orderList.get(position); //get item on list

        holder.itemPrice.setText("Rp. "+ String.valueOf(item.getPrice()));
        holder.itemName.setText(item.getItemName());
        holder.quantity.setText("Quantity: "+String.valueOf(item.getQuantity()));
        holder.totalPrice.setText("Total Price: Rp." +String.valueOf(item.getTotalPrice()));
    }
    @Override
    public int getItemCount(){
        return orderList.size();
    }
    public void setOrders(List<Orders> dataset){
        this.orderList=dataset;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemName,itemPrice,quantity,totalPrice;
        Button btn;
        ViewHolder(View view){
            super(view);
            itemName= view.findViewById(R.id.itemName);
            itemPrice= view.findViewById(R.id.itemPrice);
            quantity=view.findViewById(R.id.itemQuantity);
            totalPrice=view.findViewById(R.id.totalPrice);
        }
    }
}
