package com.example.helpick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter adapter = new ItemAdapter((ItemAdapter.OnItemClickListener) this);

        adapter.addItem(new Item("제비뽑기"));
        adapter.addItem(new Item("가위바위보"));
        adapter.addItem(new Item("돌림판"));
        adapter.addItem(new Item("숫자뽑기"));

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        //Toast.makeText(this,Integer.toString(position),Toast.LENGTH_SHORT).show();
        Intent intent;
        switch (position){
            case 0: intent = new Intent(getApplicationContext(), DrawingLotsActivity.class); break;
            case 1: intent = new Intent(getApplicationContext(), RockPaperScissorsActivity.class); break;
            case 2: intent = new Intent(getApplicationContext(), TurntableActivity.class); break;
            case 3: intent = new Intent(getApplicationContext(), RandomNumberActivity.class); break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }

        startActivity(intent);

    }
}