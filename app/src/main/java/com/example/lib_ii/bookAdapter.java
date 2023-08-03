package com.example.lib_ii;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(arrL.get(position).m_id));
        holder.name.setText(arrL.get(position).m_name);
        holder.author.setText(arrL.get(position).m_author);
        holder.pNumber.setText(arrL.get(position).m_page);


    }

    @Override
    public int getItemCount() {
        return arrL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, author, pNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvID);
            name = itemView.findViewById(R.id.tvName);
            author = itemView.findViewById(R.id.tvAuthor);
            pNumber = itemView.findViewById(R.id.tvPages);

        }
    }
    public void setData(ArrayList<Model> newData) {
        arrL.clear();
        arrL.addAll(newData);
        notifyDataSetChanged();
    }


}
