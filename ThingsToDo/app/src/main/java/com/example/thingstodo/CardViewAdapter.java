package com.example.thingstodo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CardViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> array;
    private final ArrayList<String> body;





    public CardViewAdapter(Activity context, ArrayList<String> array, ArrayList<String> body) {
        super(context, R.layout.cardview, array);
        this.context = context;
        this.array = array;
        this.body = body;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View newView = inflater.inflate(R.layout.cardview, null, true);

        TextView tv1 = newView.findViewById(R.id.tv_title);
        TextView tv2 = newView.findViewById(R.id.tv_text);
        Switch switch1 = newView.findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context, "Task is active", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Not Active", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tv1.setText(array.get(position));
        tv2.setText(body.get(position));

        return newView;

    }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


}
