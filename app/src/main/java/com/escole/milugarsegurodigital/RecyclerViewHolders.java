package com.escole.milugarsegurodigital;
import android.content.Intent;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
class RecyclerViewHolders extends RecyclerView.ViewHolder implements
        View.OnClickListener {
    TextView name;
    TextView description;
    ImageView image;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.name);
        description = itemView.findViewById(R.id.description);
        image = itemView.findViewById(R.id.img);
    }
    @Override
    public void onClick(View view) {
        Log.i("app", "viewClicked");
        Intent completeView = new Intent(itemView.getContext(),breath.class);
        Log.i("app", "oi");

        if (selectedItems.get(getAdapterPosition(), false)) {
            selectedItems.delete(getAdapterPosition());
            view.setSelected(false);


        }
        else {
            selectedItems.put(getAdapterPosition(), true);
            view.setSelected(true);

        }
    }
}