package com.example.mrinalinigalle.relation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] name={
            "Ms.Cutie Girl",
            "Mr. Nerdie Boy",
            "Mrs. Multi-tasker Mom",
            "Mr. Superhero Dad",
            "Mrs. Lovely Grandmom",
            "Mr. Hardworking Grandpa"};
    String[] relation={
            "Daughter",
            "Son",
            "Mother",
            "Father",
            "Grandmother",
            "Grandfather"
    };

    Integer[] imageId={
            R.drawable.girl,
            R.drawable.boy,
            R.drawable.mumma,
            R.drawable.dad,
            R.drawable.grandmother,
            R.drawable.dadu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        CustomList adapter = new CustomList(MainActivity.this,name,relation,imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


    }
}
