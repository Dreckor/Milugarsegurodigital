package com.escole.milugarsegurodigital.recyclers;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.escole.milugarsegurodigital.R;
import com.escole.milugarsegurodigital.final_solution_choose;
import com.escole.milugarsegurodigital.models.solution;
import com.escole.milugarsegurodigital.solutions;

import java.util.List;

public class solutionRecycler extends RecyclerView.Adapter<solutionRecycler.ViewHold> {
    private List<solution> solutionList;
    private Context context;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public solutionRecycler(Context context, List<solution> solutionList){
        this.solutionList = solutionList;
        this.context = context;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType){
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.solution_box,parent,false);
        return new ViewHold(layout);
    }
    @Override
    public void onBindViewHolder(ViewHold holder, final int position){
        holder.solution.setText(solutionList.get(position).getName());
        holder.icon.setImageResource(solutionList.get(position).getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItems.get(position,false)){
                    selectedItems.delete(position);
                    v.setSelected(false);
                }else{
                    selectedItems.put(position,true);
                    v.setSelected(true);
                    Intent intent = new Intent(v.getContext(), final_solution_choose.class);
                    intent.putExtra("name", position);
                    v.getContext().startActivity(intent);

                }
            }
        });
    }
    @Override
    public int getItemCount(){return this.solutionList.size();}

    public class ViewHold extends RecyclerView.ViewHolder{
        private ImageView icon;
        private TextView solution;
        public ViewHold(View itemView){
            super(itemView);
            solution = (TextView) itemView.findViewById(R.id.txt);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}
