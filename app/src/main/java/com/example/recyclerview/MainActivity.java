package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.annotation.SuppressLint;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*create a layout(res>layout) file for every file that is going to be shown in the recycler view
        *create adapter(javaClass) for the recycler view to fetch data to our recycler view
        * create an inner  class of ViewHolder(in the javaClass) to hold the data of the recycler view
        * extended the javaClass with the viewHolder and implement the methods of the adapter
        * create a java class to store the data of the recycler view
        * */

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //create an instance of the recycler view adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts("John Doe", "9876543210", "https://static.wikia.nocookie.net/villains/images/a/a0/John_Doe_game.png/revision/latest/scale-to-width/360?cb=20220428022008.jpg"));
        contacts.add(new Contacts("John Doe", "9876543210", "https://static.wikia.nocookie.net/villains/images/a/a0/John_Doe_game.png/revision/latest/scale-to-width/360?cb=20220428022008.jpg"));
        adapter.setContacts(contacts);
    }
}