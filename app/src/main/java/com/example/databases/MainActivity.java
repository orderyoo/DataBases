package com.example.databases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button add;

    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBase db = Room.databaseBuilder(getApplicationContext(), DataBase.class, "database").build();
        dao = db.groupDao();

        listView = findViewById(R.id.listViewXml);

        Adapter adapter = new Adapter(this, android.R.layout.simple_expandable_list_item_1, dao.getAll());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, OpenActivity.class);
            intent.putExtra("position", position);
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = new Group(11, "21it17", "43");
                db.groupDao().insertAll(group);
                adapter.notifyDataSetChanged();
            }
        });

    }

}