package com.example.wwlproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class  Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements View.OnClickListener {

    private List<ProductValue> products;
    private Context context;
    private RecyclerViewClickListener listener;

    public Adapter(List<ProductValue> products, Context context ) {
        this.products = products;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(products.get(position).getName());
        holder.description.setText(products.get(position).getDescription());
        holder.price.setText(products.get(position).getPrice());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(context, Order.class);
//                intent5.putExtra("name",products.get(position).getName());
//                intent5.putExtra("description",products.get(position).getDescription());
//                intent5.putExtra("price",products.get(position).getPrice().toString());
//                intent5.putExtra("imageurl",products.get(position).getImage());
                context.startActivity(intent5);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onClick(View view) {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,description,price;
        LinearLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);

            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
