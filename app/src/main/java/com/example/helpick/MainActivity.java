package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter adapter = new ItemAdapter();

        adapter.addItem(new Item("제비뽑기"));
        adapter.addItem(new Item("가위바위보"));
        adapter.addItem(new Item("돌림판"));
        adapter.addItem(new Item("숫자뽑기"));

        recyclerView.setAdapter(adapter);



    }
}