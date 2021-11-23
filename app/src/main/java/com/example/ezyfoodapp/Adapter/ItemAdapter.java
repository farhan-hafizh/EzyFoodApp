package com.example.ezyfoodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfoodapp.Model.Item;
import com.example.ezyfoodapp.Order;
import com.example.ezyfoodapp.R;
import com.example.ezyfoodapp.createOrder;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> itemList;
    private createOrder activity;
    private Context context;

    public ItemAdapter(createOrder activity){
        this.activity=activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Item item = itemList.get(position); //get item on list

        holder.itemPrice.setText("Rp. "+ String.valueOf(item.getPrice()));
        holder.itemName.setText(item.getItemName());
    }
    @Override
    public int getItemCount(){
        return itemList.size();
    }

    public void setItem(List<Item> dataset){
        this.itemList=dataset;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemName,itemPrice;
        Button btn;
        ViewHolder(View view){
            super(view);
            context = itemView.getContext();
            itemName= view.findViewById(R.id.itemName);
            itemPrice= view.findViewById(R.id.itemPrice);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {

            final Intent intent;
                intent =  new Intent(context, Order.class);
                intent.putExtra("item_name","Air Mineral");
                intent.putExtra("price","123");
            context.startActivity(intent);
        }
    }
}
