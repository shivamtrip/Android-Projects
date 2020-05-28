package com.example.basiclistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CardViewAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String [] names;
    private final String [] qualities;

    public CardViewAdapter(Activity context, String[] names, String[] qualities) {
        super(context, R.layout.card_view, names);
        this.context = context;
        this.names = names;
        this.qualities = qualities;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View newView = inflater.inflate(R.layout.card_view, null, true);

        ImageView imageView = newView.findViewById(R.id.imageView2);
        TextView tv1 = newView.findViewById(R.id.textView1);
        TextView tv2 = newView.findViewById(R.id.textView2);

        tv1.setText(names[position]);
        tv2.setText(qualities[position]);

        return newView;
    }
}
