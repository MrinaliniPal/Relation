package com.example.mrinalinigalle.relation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;


public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] relation;
    private final Integer[] imageId;
    public Firebase firebase;

    public CustomList(Activity context, String[] name,String[] relation,Integer[] imageId) {
        super(context, R.layout.single_row, name);
        this.context = context;
        this.name = name;
        this.relation=relation;
        this.imageId = imageId;
        firebase.setAndroidContext(context);
        firebase = new Firebase("https://relationalmanac1.firebaseio.com/");
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_row, null, true);

        final TextView txtTitle1 = (TextView) rowView.findViewById(R.id.txt1);
        final ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        final TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);

        txtTitle1.setText(name[position]);
        txtTitle2.setText(relation[position]);
        imageView.setImageResource(imageId[position]);

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtTitle1.setText(String.valueOf(dataSnapshot.child(String.valueOf(position)).child("Name").getValue()));
                txtTitle2.setText(String.valueOf(dataSnapshot.child(String.valueOf(position)).child("Relation").getValue()));
                Picasso.with(getContext()).load(String.valueOf(dataSnapshot.child(String.valueOf(position)).child("ImageUrl").getValue())).into(imageView);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return rowView;
    }
}