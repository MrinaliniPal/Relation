package com.example.mrinalinigalle.relation;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView list;
    String[] name={
            "Mr. Superhero Dad",
            "Mrs. Multi-tasker Mom",
            "Mr. Nerdie Boy",
            "Ms.Cutie Girl",
            "Mr. Hardworking Grandpa",
            "Mrs. Lovely Grandmom"
    };
    String[] relation={
            "Father",
            "Mother",
            "Son",
            "Daughter",
            "Grandfather",
            "Grandmother"
    };

    Integer[] imageId={
            R.drawable.dad,
            R.drawable.mumma,
            R.drawable.boy,
            R.drawable.girl,
            R.drawable.dadu,
            R.drawable.grandmother
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomList adapter = new CustomList(MainActivity.this,name,relation,imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent s=new Intent(MainActivity.this,MapsActivity.class);
                s.putExtra("KEY",position);
                startActivity(s);
            }
        });
    }
}
