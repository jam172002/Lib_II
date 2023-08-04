package com.example.lib_ii;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.ViewHolder> {

    Context context;
    ArrayList<Model> arrL = new ArrayList<>();

    //constructor for adapter
    public bookAdapter(Context context, ArrayList<Model> arrL){
    this.context = context;
    this.arrL =  arrL;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.id.setText(String.valueOf(arrL.get(position).m_id));
        holder.name.setText(arrL.get(position).m_name);
        holder.author.setText(arrL.get(position).m_author);
        holder.pNumber.setText(arrL.get(position).m_page);

        //this click listener will enable the item shown on recycler view click able
        holder.updateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("name", String.valueOf(arrL.get(position).m_name));
                intent.putExtra("author", String.valueOf(arrL.get(position).m_author));
                intent.putExtra("pNumber", String.valueOf(arrL.get(position).m_page));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, author, pNumber;
        ConstraintLayout updateLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvID);
            name = itemView.findViewById(R.id.tvName);
            author = itemView.findViewById(R.id.tvAuthor);
            pNumber = itemView.findViewById(R.id.tvPages);
            updateLayout = itemView.findViewById(R.id.updateLayout);

        }
    }
    public void setData(ArrayList<Model> newData) {
        arrL.clear();
        arrL.addAll(newData);
        notifyDataSetChanged();
    }


}
