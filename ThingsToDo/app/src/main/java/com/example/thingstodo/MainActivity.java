package com.example.thingstodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView lv;
    EditText et;
//    TextView tv;
    ArrayAdapter<String> adapter;
    ArrayList<String> array;
    ArrayList<String> body;
    FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        lv = findViewById(R.id.lv);



//        et = findViewById(R.id.et);

//        array = new ArrayList<String>();

//        array.add("Hello");
//        array.add("What's Up?");
//        array = FileHelper.readData(this);
//        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, array);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(this);


        array = FileHelper.readData(this);
        body = FileHelper.readData1(this);

        final CardViewAdapter myAdapter = new CardViewAdapter(this, array, body);
        lv.setAdapter(myAdapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                array.remove(position);
                body.remove(position);
                myAdapter.notifyDataSetChanged();
                FileHelper.writeData(array, MainActivity.this);
                FileHelper.writeData1(body, MainActivity.this);

                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, array.get(position), Toast.LENGTH_SHORT).show();
            }
        });


//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                array.remove(position);
//                body.remove(position);
//                myAdapter.notifyDataSetChanged();
//                FileHelper.writeData(array, MainActivity.this);
//                FileHelper.writeData1(body, MainActivity.this);
//
//                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        Log.d(TAG, "onCreate: Array = " + array);

        Log.d(TAG, "onCreate: Body =  " + body);

//        Intent intent = getIntent();
//
//        String title_got = intent.getStringExtra("title");
//
//        Log.d(TAG, "Button Pressed and " + title_got + " was typed.");



        Log.d(TAG, "onCreate: Started Singing bro");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, AddScreen.class);
                startActivity(newIntent);
            }
        });


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String task = et.getText().toString();
//                array.add(task);
//                et.setText("");
//
//                Log.d(TAG, "Button Pressed and " + task + " was typed.");
//            }
//        });

        // Below code allows enter button pressed on keyboard to perform same action as button clicked
//        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
//                    //do what you want on the press of 'done'
//                    button.performClick();
//                }
//                return false;
//            }
//        });
    }
    
    private static final String TAG = "MainActivity";

//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        array.remove(position);
//        adapter.notifyDataSetChanged();
//        FileHelper.writeData(array, this);
//
//        Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
