package com.escole.milugarsegurodigital;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.escole.milugarsegurodigital.models.activity;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewHolders> {
    private List<activity> itemList;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    RecyclerViewAdapter(Context context, List<activity> itemList) {
        this.itemList = itemList;
    }
    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity, null);
        return new RecyclerViewHolders(layoutView);
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, final int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.description.setText(itemList.get(position).getDescription());
        holder.image.setImageResource(itemList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View view){
                if(selectedItems.get(position,false)){
                    selectedItems.delete(position);
                    view.setSelected(false);
                }else{
                    selectedItems.put(position,true);
                    view.setSelected(true);
                    Intent intent = new Intent(view.getContext(), breath.class);
                    intent.putExtra("image", itemList.get(position).getImage());
                    view.getContext().startActivity(intent);
                }
            }
        });


    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}