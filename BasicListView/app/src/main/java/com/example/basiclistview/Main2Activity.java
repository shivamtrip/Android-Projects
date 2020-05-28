package com.example.basiclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

//    TextView hello;
//    ImageView img;
//    TextView bye;

    ImageView imgview;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String s = intent.getStringExtra("name");
        String q = intent.getStringExtra("qualities");

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        imgview = findViewById(R.id.iv2);

//        hello = findViewById(R.id.title_tv);
//        img = findViewById(R.id.img);
//        bye = findViewById(R.id.sub_tv);

        tv1.setText(s);
        tv2.setText(q);
//
//        hello.setText(s);
//        bye.setText(q);
    }

    public void setText(){

    }
}
