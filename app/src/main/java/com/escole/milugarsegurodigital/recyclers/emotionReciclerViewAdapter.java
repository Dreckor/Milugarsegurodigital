package com.escole.milugarsegurodigital.recyclers;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.escole.milugarsegurodigital.R;

import com.escole.milugarsegurodigital.breath;
import com.escole.milugarsegurodigital.models.activity;
import com.escole.milugarsegurodigital.models.emotion;

import java.util.ArrayList;
import java.util.List;

public class emotionReciclerViewAdapter extends RecyclerView.Adapter<emotionReciclerViewAdapter.ViewHold> {

    private List<emotion> emotionList;
    private Context context;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public emotionReciclerViewAdapter(Context context, List<emotion> emotionList) {
        this.emotionList = emotionList;
        this.context = context;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.caritas,parent, false);
        return new ViewHold(layoutView);
    }
    @Override
    public void onBindViewHolder(ViewHold holder, final int position) {
        holder.emotion.setText(emotionList.get(position).getEmotion());
        holder.img.setImageResource(emotionList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View view){
                if(selectedItems.get(position,false)){
                    selectedItems.delete(position);
                    view.setSelected(false);
                }else{
                    selectedItems.put(position,true);
                    view.setSelected(true);
                    Intent intent = new Intent(view.getContext(), breath.class);
                    intent.putExtra("image", emotionList.get(position).getImage());
                    view.getContext().startActivity(intent);
                }
            }
        });


    }
    @Override
    public int getItemCount() {
        return this.emotionList.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView emotion;

        public ViewHold(View itemView){
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            emotion = (TextView) itemView.findViewById(R.id.emotion);
        }
    }
}
