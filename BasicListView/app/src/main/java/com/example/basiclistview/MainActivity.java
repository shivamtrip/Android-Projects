package com.example.basiclistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    TextView tv;
    ListView lv;
    String temp;
    String b;

    //    final ArrayList<String> names = new ArrayList<String>(
//            Arrays.asList("RAJ", "Rohan", "AMIT", "Sharma", "Babloo"));
//
    final String names[] = {"John", "Tim", "Phillip", "Harry", "Jim"};

    final String qualities[] = {"Strong", "Sharp", "Fit", "Fast", "Good"};

//    final ArrayList<String> someNames = new ArrayList<String>(
//            Arrays.asList("JOHN", "MIke", "TIM", "GUNTER", "Rooney"));

//
//    final ArrayList<String> qualities = new ArrayList<String>(
//            Arrays.asList("Strong", "Sharp", "Fit", "Fast", "Good"));


    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        switch(id) {
//            case R.id.ref_for:
//                adapter = new ArrayAdapter<String>(
//                        MainActivity.this, R.layout.activity_tv, names);
//                lv.setAdapter(adapter);
//            case R.id.ref_back:
//                adapter = new ArrayAdapter<String>(
//                        MainActivity.this, R.layout.activity_tv, someNames);
//                lv.setAdapter(adapter);
//        }
//
//        return true;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        tv = findViewById(R.id.tv);

        CardViewAdapter myAdapter = new CardViewAdapter(this, names, qualities);
        lv.setAdapter(myAdapter);


//        adapter = new ArrayAdapter<String>(
//                MainActivity.this, R.layout.activity_tv, names);
//        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You clicked on " + names[position] + "'s profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                String myName = names[position];
                intent.putExtra("name", myName);

                String myQuality = qualities[position];
                intent.putExtra("qualities", myQuality);

                startActivity(intent);


            }
        });


    }
}
