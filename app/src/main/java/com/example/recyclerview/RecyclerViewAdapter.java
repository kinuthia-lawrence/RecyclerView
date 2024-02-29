package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<Contacts> contacts = new ArrayList<>();//initialize an array list of contacts
    private Context context;//inorder to receive images from the internet

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    // implement the methods of the adapter after extending the recycler view adapter class with the view holder we created.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {//will create different view-holder objects for each item in the recycler view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {//this is the main method in every recycler view holder
        viewHolder.name.setText(contacts.get(position).getName());
        viewHolder.number.setText(contacts.get(position).getNumber());
        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    //create an inner class of viewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{//the purpose of this ViewHolder class is to create different views(the recycler_view_list_item) for each item inside the RecyclerViewAdapter

//        initialize all items in recycler_view_list_item layout
        private ImageView imageView;
        private TextView name, number;

        public ViewHolder(@NonNull View itemView) {//(constructor)-responsible for creating layout-file for each item in recycler view
            super(itemView);
//first i have casted.Then since am not in activity file, i use itemView.findViewById() to get the view from the layout file
            imageView = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
        }
    }
}
