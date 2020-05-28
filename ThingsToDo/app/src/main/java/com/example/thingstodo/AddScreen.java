package com.example.thingstodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddScreen extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button add_btn;
    ArrayList<String> array;
    ArrayList<String> body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);


        Log.d(TAG, "onCreate: Adding screen started");

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        add_btn = findViewById(R.id.add_btn);


        array = FileHelper.readData(this);
        body = FileHelper.readData1(this);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = et1.getText().toString();
                String text = et2.getText().toString();

                array.add(title);
                body.add(text);

                Log.d(TAG, "onClick: Title = " + array);
                Log.d(TAG, "onClick: Body = " + body);

                FileHelper.writeData(array,AddScreen.this);
                FileHelper.writeData1(body, AddScreen.this);

                Intent intent = new Intent(AddScreen.this, MainActivity.class);
//                intent.putExtra("title", title);
//                intent.putExtra("text", text);
                startActivity(intent);
            }
        });
    }

    private static final String TAG = "MainActivity";
}
