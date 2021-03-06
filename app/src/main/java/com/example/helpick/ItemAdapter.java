package com.example.helpick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>implements OnItemClickListener {

    ArrayList<Item> items = new ArrayList<>();
    OnItemClickListener listener;

    public ItemAdapter(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener mlistener){
        listener = mlistener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.item_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });

        }

        public void setItem(Item item){
            tv1.setText(item.getName());
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.pick_item,parent,false);
        ViewHolder vh = new ViewHolder(itemView, listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.setItem(item);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Item item){items.add(item);}
    public void setItems(ArrayList<Item> items){this.items=items;}
    public Item getItem(int position){return items.get(position);}
    public void setItem(int position, Item item){items.set(position, item);}

    @Override
    public void onItemClick(int position) {

    }
}