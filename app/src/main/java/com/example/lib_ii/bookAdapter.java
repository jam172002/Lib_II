package com.example.lib_ii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// The bookAdapter class is a custom RecyclerView adapter responsible for displaying book data.
public class bookAdapter extends RecyclerView.Adapter<bookAdapter.ViewHolder> {

    // Context to be used for inflating views
    Context context;

    // ArrayList to hold book data
    ArrayList<Model> arrL = new ArrayList<>();

    // Constructor for the adapter
    public bookAdapter(Context context, ArrayList<Model> arrL) {
        this.context = context;
        this.arrL = arrL;
    }

    // Called when a new ViewHolder is needed to represent an item.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item and create a ViewHolder to hold the view references
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Called to bind the data to the ViewHolder.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind the data from the ArrayList to the ViewHolder views for each item.
        holder.id.setText(String.valueOf(arrL.get(position).m_id));
        holder.name.setText(arrL.get(position).m_name);
        holder.author.setText(arrL.get(position).m_author);
        holder.pNumber.setText(arrL.get(position).m_page);
    }

    // Return the number of items in the ArrayList.
    @Override
    public int getItemCount() {
        return arrL.size();
    }

    // ViewHolder class to hold the references to the views for each item.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, author, pNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the TextViews for each item view.
            id = itemView.findViewById(R.id.tvID);
            name = itemView.findViewById(R.id.tvName);
            author = itemView.findViewById(R.id.tvAuthor);
            pNumber = itemView.findViewById(R.id.tvPages);
        }
    }

    // Method to update the data in the adapter and refresh the view.
    public void setData(ArrayList<Model> newData) {
        arrL.clear(); // Clear the existing data in the ArrayList.
        arrL.addAll(newData); // Add new data from the parameter ArrayList.
        notifyDataSetChanged(); // Notify the adapter that the data has changed.
    }
}
