package com.example.basicrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Things required to get recyclerview working -
// 1. Create and set up Custom Adapter for Recycler View
// 2. Set Layout Manager for your recyclerView
// 3. Set your adapter created to your recyclerView
// 4. Create RecyclerItemClickListener and implement it in the MainActivity as shown below.

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener.OnRecyclerClickListener {

    RecyclerView mRecyclerView;
    private MyAdapter adapter;
    ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArrayList = new ArrayList<>(Arrays.asList("John", "Mike", "Jordan", "Tom", "Jerry", "Ben", "Thomas", "Henry"));

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, mRecyclerView, this));

//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());   //layout manager tells the adapter to
        mRecyclerView.setHasFixedSize(true);                                            // that new views are coming on the screen
        mRecyclerView.setLayoutManager(layoutManager);                                  // so please bring that view's respective data

        adapter = new MyAdapter(this, mArrayList);

        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "Normal tap at position " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra("NAME", mArrayList.get(position));
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "Long tap at position " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.menu_settings:
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
                break;
            case R.id.menu_share:
                Toast.makeText(this, "Share feature not added yet", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
